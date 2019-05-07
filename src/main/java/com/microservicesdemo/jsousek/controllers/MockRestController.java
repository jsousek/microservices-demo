package com.microservicesdemo.jsousek.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/mock")
public class MockRestController {

    @GetMapping(value = "/free")
    public ResponseEntity<String> mockWithoutSecurity(){
        return ResponseEntity.ok("hello, this is jwt unprotected controller");
    }

    @GetMapping(value ="/protected")
    public ResponseEntity<String> mockSecured(){
        return ResponseEntity.ok("secured endpoint");
    }
}
