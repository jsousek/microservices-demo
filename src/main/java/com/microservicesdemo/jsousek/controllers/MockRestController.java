package com.microservicesdemo.jsousek.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockRestController extends BaseController{

    @GetMapping(value = "/mock/free")
    public ResponseEntity<String> mockWithoutSecurity(){
        return ResponseEntity.ok("hello, this is jwt unprotected controller");
    }

    @GetMapping(value ="/mock/protected")
    public ResponseEntity<String> mockSecured(){
        return ResponseEntity.ok("secured endpoint");
    }
}
