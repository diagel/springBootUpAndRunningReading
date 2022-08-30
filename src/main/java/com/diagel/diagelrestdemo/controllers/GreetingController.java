package com.diagel.diagelrestdemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @Value("${name: daler}")
    private String name;
    @Value("${greeting-delivery: ${name} это транспортная компания}")
    private String info;

    @GetMapping
    String getGreeting(){
        return name;
    }

    @GetMapping("/stl")
    String getNameAndCoffee(){
        return info;
    }
}
