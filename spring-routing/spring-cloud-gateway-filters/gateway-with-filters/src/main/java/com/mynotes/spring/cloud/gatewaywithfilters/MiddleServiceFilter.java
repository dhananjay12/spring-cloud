package com.mynotes.spring.cloud.gatewaywithfilters;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Component
public class MiddleServiceFilter extends AbstractGatewayFilterFactory {

    final Logger logger =
        LoggerFactory.getLogger(MiddleServiceFilter.class);

    private final WebClient client=WebClient.create();

    @Value("${app.middle-service-url:http://localhost:8085/check}")
    private String middleServiceUrl;

   // public MiddleServiceFilter(WebClient.Builder client) {
//        this.client = client;
//    }

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {

            final ServerHttpRequest request = exchange.getRequest();

            final Mono<ClientResponse> middleServiceResponse = callMiddleService();

            Mono<Void> middleService = middleServiceResponse
                .flatMap(r -> processMiddleResponse(exchange, chain, request, r));

            return middleService.then();
        };
    }


    private Mono<ClientResponse> callMiddleService() {

        WebClient.RequestBodySpec request = client.method(HttpMethod.GET).uri(middleServiceUrl);

        logger.debug("callMiddleService");

        return request.exchange();
    }

    private Mono<Void> processMiddleResponse(ServerWebExchange exchange, GatewayFilterChain chain,
        ServerHttpRequest request, ClientResponse middleServiceResponse) {
        if (middleServiceResponse.statusCode().is2xxSuccessful()) {
            final ServerHttpRequest.Builder modifiedRequestBuilder = request.mutate();
            for (String headerKey : middleServiceResponse.headers().asHttpHeaders().keySet()) {
                List<String> headerValue = middleServiceResponse.headers().asHttpHeaders().get(headerKey);
                modifiedRequestBuilder.header(headerKey, headerValue.toArray(new String[headerValue.size()]));
            }
            return chain.filter(exchange.mutate().request(request).build());

        } else {

            Mono<String> errorMono = middleServiceResponse.body(BodyExtractors.toMono(String.class))
                .doOnNext(
                    it -> logger.error("Middle service error code {} {}", middleServiceResponse.statusCode(), it));

            return errorMono
                .then(Mono.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "Middle service error code")));

        }
        //return chain.filter(exchange);

    }


}
