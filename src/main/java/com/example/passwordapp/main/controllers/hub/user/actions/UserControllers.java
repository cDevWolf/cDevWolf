package com.example.passwordapp.main.controllers.hub.user.actions;

import com.example.passwordapp.models.entity.Item;
import com.example.passwordapp.models.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/v1/user")
@SessionAttributes("items")
public class UserControllers {
    @Autowired
    private ItemService itemService;
    @GetMapping("/profile")
    public String getProfileData(){
        return "profile";
    }
    @ModelAttribute("items")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }
}
