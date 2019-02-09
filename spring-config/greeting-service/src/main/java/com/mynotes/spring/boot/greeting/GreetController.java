package com.mynotes.spring.boot.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

    @Value("${message.default.welcome}")
    private String welcomeMessage;

    @Value("${message.default.goodbye}")
    private String goodBye;

    @Autowired
    MessageProperties messageProperties;

    @RequestMapping("/welcome")
    public String welcome() {
        return messageProperties.getWelcome();
    }

    @RequestMapping("/bye")
    public String bye() {
        return goodBye;
    }

}
