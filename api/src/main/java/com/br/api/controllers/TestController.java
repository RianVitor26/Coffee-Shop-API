package com.br.api.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {
    
    @RequestMapping("/test")
    public String testRoute() {
        return "Testing a route with controller";
    }
}
