package com.example.passwordapp.main.controllers.hub.keys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/keys")
public class KeysController {
    @GetMapping("/all-keys")
    public String goToAllKeys(){
        return "allkeys";
    }
}
