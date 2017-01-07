package com.mynotes.spring.cloud.feign;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@Autowired
	private IntegrationClient integrationClient;

	

	@GetMapping(value="/offersAndRecommendation" ,produces ={MediaType.APPLICATION_JSON_VALUE})
	public Map<String,Collection> offersAndRecommendation() {
		Map<String,Collection> result=new HashMap<String,Collection>();
		result.put("offers", integrationClient.getOffers());
		result.put("recommendations", integrationClient.getRecommendations());
		return result;
		
	}

}
