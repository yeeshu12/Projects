package com.example.mywebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/atm")
    public String atm() {
        return "atm";
    }

    @RequestMapping("/about")
    public String getOtherPage() {
        return "about";
    }
}
