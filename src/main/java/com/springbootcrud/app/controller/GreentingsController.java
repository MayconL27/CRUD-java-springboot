package com.springbootcrud.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreentingsController {

    @GetMapping(value="/maycon")
    public String getMethodName() {
        return "Olá Mundo VSCode!";
    }
    
}
