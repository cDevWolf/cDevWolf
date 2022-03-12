package com.example.passwordapp.main.controllers.hub;

import com.example.passwordapp.models.entity.Item;
import com.example.passwordapp.models.service.item.ItemService;
import com.example.passwordapp.models.service.item.ItemServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class IndexController {
    Logger log = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private ItemService itemService;
    @GetMapping({"/", "/app"})
    public String goToIndex(Model model){
        model.addAttribute("Val", "value");
        model.addAttribute("items", itemService.getAllItems());
        for(Item item : itemService.getAllItems()){
            System.out.println((item.getName() + " " + item.getPath()));
        }
        log.info("Value");
        return "index";
    }
}
