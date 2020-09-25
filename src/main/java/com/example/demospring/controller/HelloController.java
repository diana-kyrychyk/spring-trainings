package com.example.demospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(name="name", required=true) String name, Model model) {
        model.addAttribute("myMessage", "My first Spring application for EPAM trainings");
        model.addAttribute("nameParam", name);
        System.out.println("Hello!");
        return "hello-page";
    }

    @GetMapping("/")
    public String index() {
        System.out.println("Hello!");
        return "index";
    }



}
