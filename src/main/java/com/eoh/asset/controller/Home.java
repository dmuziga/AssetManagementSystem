package com.eoh.asset.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class Home {

    @GetMapping
    public String LoginForm(){

        return "HomeLogin";
    }

    @GetMapping("/homePage")
    public String homePage(){


        return "homePage";
    }

}
