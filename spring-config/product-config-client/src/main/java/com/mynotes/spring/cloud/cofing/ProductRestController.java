package com.mynotes.spring.cloud.cofing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ProductRestController {

	@Value("${display.offers.message}")
	private String message;

	@RequestMapping("/offer-message")
	public String offerMessage() {
		return this.message;
	}

}
