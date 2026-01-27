package com.example.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Depocontroller {


    @GetMapping("/deposit")
    public String depo(){
        return "deposit";
    }


    @GetMapping("/panel")
    public String panel(){
        return "panel";
    }
}

