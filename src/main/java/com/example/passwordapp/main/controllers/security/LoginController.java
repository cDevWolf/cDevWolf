package com.example.passwordapp.main.controllers.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginPage(Model model, Principal principal, RedirectAttributes flash){
        return "login";
    }
}
