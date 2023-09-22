package edu.mum.cs.cs425.eRegistrar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/eregister/home")
public class HomeController {
    @GetMapping
    public String showHomePage(){
        return "home/index";
    }
}
