package com.example.passwordapp.main.controllers.hub;

import com.example.passwordapp.models.entity.Item;
import com.example.passwordapp.models.entity.User;
import com.example.passwordapp.models.security.UserDetails.UserDetailsServiceImpl;
import com.example.passwordapp.models.security.UserDetails.UserForUserDetails;
import com.example.passwordapp.models.service.item.ItemService;
import com.example.passwordapp.models.service.item.ItemServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/v1")
public class IndexController {
    Logger log = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private ItemService itemService;
    @GetMapping({"/", "/app", "/app/dashboard"})
    public String goToIndex(Model model, Principal principal){
        /*
        UserForUserDetails userDetails = (UserForUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println(userDetails.getUsername());
        */

        model.addAttribute("Val", "value");
        model.addAttribute("items", itemService.getAllItems());

        log.info("Value");
        return "index";
    }
}
