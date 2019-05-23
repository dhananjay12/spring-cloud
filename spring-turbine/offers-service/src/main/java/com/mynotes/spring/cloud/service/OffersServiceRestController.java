package com.mynotes.spring.cloud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OffersServiceRestController {

	@RequestMapping(value = "/getCurrentOffers", method = RequestMethod.GET)
	@ResponseBody
	public List<Offers> getCurrentOffers() {
		List<Offers> offers = new ArrayList<Offers>();
		offers.add(new Offers("Offer1", "Description1", "link1"));
		offers.add(new Offers("Offer2", "Description2", "link3"));
		offers.add(new Offers("Offer3", "Description3", "link3"));
		return offers;
	}

}
