package com.codestaes.soloproject.home;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Homecontroller {
    @GetMapping("/")
    public ResponseEntity helloWorld() {
        return ResponseEntity.ok().body(
                Map.of("hello", "world")
        );
    }
}
