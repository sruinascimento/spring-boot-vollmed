package br.com.rsfot.vollmed.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/helloworld")
    ResponseEntity<String> sayHelloWorld() {
        return ResponseEntity.ok("<h1>Spring Boot</h1>");
    }
}
