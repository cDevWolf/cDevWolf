package com.example.passwordapp.main.controllers.hub;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class IndexController {
    @GetMapping({"/", "/app"})
    public String goToIndex(){
        return "index";
    }
}
