package com.mynotes.spring.cloud.gatewayendservice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class EndController {

   // @Value("${app.omitHeaders:}")
    private Set<String> omitHeaders = new HashSet<>(Arrays.asList("Content-Length", "Content-Type", "Transfer-Encoding"));

    @RequestMapping(value = {"/headers"})
    @ResponseBody
    public Map<String, Map<String, String>> headers(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Map<String, String>> headers = new HashMap<>();

        if (request != null && request.getHeaderNames() != null) {
            Map<String, String> requestHeaders = new HashMap<>();

            headers.put("request", requestHeaders);
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                requestHeaders.put(headerName, request.getHeader(headerName));
            }
        }

        if (response != null && response.getHeaderNames() != null) {
            Map<String, String> responseHeaders = new HashMap<>();

            headers.put("response", responseHeaders);
            for (String headerName : response.getHeaderNames()) {
                responseHeaders.put(headerName, response.getHeader(headerName));
            }
        }

        return headers;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,
        @RequestParam(value = "delay", required = false, defaultValue = "0") int delay) throws Exception {

        System.out.println(String.join(System.getProperty("line.separator"),
            "File Name => " + file.getOriginalFilename(),
            "File Size => " + file.getSize() + "bytes",
            "File Content Type => " + file.getContentType()));

        TimeUnit.MILLISECONDS.sleep(delay);

        return ResponseEntity.ok(file.getName() + " uploaded");
    }

    public Set<String> getOmitHeaders() {
        return omitHeaders;
    }
}
