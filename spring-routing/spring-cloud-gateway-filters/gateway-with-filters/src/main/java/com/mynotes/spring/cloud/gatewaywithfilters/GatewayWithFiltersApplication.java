package com.mynotes.spring.cloud.gatewaywithfilters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@SpringBootApplication
public class GatewayWithFiltersApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayWithFiltersApplication.class, args);
    }

    @Bean
    WebClient.Builder webClient() {
        return webClientBuilder();
        //return WebClient.builder();
    }


     private WebClient.Builder webClientBuilder() {
        return WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector(
                HttpClient.newConnection().compress(true)));
    }
}
