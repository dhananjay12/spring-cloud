package com.mynotes.spring.boot.greeting;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @Value("${welcome.default.message}")
    private String welcomeMessage;

    @RequestMapping("/welcome")
    public String offerMessage() {
        return welcomeMessage;
    }

}
