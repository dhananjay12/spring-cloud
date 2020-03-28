package com.mynotes.spring.cloud.gatewaymiddleservice;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiddleController {

    @GetMapping("/check")
    public ResponseEntity<?> check(HttpServletRequest request, HttpServletResponse response) {

        if (request != null && request.getHeaderNames() != null) {
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                System.out.println(headerName +"=="+request.getHeader(headerName));
            }
        }
        return ResponseEntity.ok().header("some-header", "some-value").build();
    }

}
