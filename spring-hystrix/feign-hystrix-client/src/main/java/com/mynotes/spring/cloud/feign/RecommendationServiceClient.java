package com.mynotes.spring.cloud.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mynotes.spring.cloud.service.Product;

@FeignClient("recommendation-service")
public interface RecommendationServiceClient {

    @RequestMapping(value = "/recommendations", method = RequestMethod.GET)
    public List<Product> getRecommendations();

}