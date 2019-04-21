package com.mynotes.spring.cloud.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mynotes.spring.cloud.service.Offers;

@FeignClient("offers-service")
public interface OffersServiceClient {

    @RequestMapping(value = "/getCurrentOffers", method = RequestMethod.GET)
    public List<Offers> getCurrentOffers();

}