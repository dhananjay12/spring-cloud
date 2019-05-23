package com.mynotes.spring.cloud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecommendationServiceRestController {

    @RequestMapping(value = "/recommendations", method = RequestMethod.GET)
    @ResponseBody
    public List<Product> getCurrentOffers() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("Product1", "Description1", "link1"));
        products.add(new Product("Product2", "Description2", "link3"));
        products.add(new Product("Product3", "Description3", "link3"));
        return products;
    }

}
