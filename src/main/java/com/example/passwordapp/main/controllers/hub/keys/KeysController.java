package com.example.passwordapp.main.controllers.hub.keys;

import com.example.passwordapp.models.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/keys")
public class KeysController {
    @Autowired
    private ItemService itemService;
    @GetMapping("/all-keys")
    public String goToAllKeys(Model model){
        model.addAttribute("items", itemService.getAllItems());
        return "allkeys";
    }
}