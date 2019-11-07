package com.mynotes.spring.cloud.eureka;

import java.util.concurrent.TimeUnit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {

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

}