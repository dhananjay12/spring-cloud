package com.mynotes.spring.boot.greeting;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "gateway")
public class Moreproperties {


    public Map<String, ServiceProp> getServices() {
        return services;
    }

    public void setServices(Map<String, ServiceProp> services) {
        this.services = services;
    }

    private Map<String, ServiceProp> services = new HashMap<>();

}
