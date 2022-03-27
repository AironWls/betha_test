package br.com.betha_test.betha_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("home")
    public String home() {
        return "home";
    }

}
