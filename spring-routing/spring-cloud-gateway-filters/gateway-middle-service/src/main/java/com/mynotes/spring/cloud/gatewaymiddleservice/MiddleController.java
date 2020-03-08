package com.mynotes.spring.cloud.gatewaymiddleservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiddleController {

    @GetMapping("/check")
    public ResponseEntity<?> check(HttpServletRequest request, HttpServletResponse response) {
        return ResponseEntity.ok().header("some-header", "some-value").build();
    }

}
