package com.example.passwordapp.main.controllers.hub.keys;

import com.example.passwordapp.models.entity.Item;
import com.example.passwordapp.models.entity.Key;
import com.example.passwordapp.models.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/keys")
@SessionAttributes("items")
public class KeysController {

    @Autowired
    private ItemService itemService;
    @GetMapping("/all-keys")
    public String goToAllKeys(Model model){
        return "allkeys";
    }
    @GetMapping("/register-key")
    private String registerNewKey(Model model){
        model.addAttribute("key", new Key());
        return "register-key";
    }


    @PostMapping("/register-key")
    private String registerKeyPost(Model model, @Valid Key key, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("key", key);
            return "register-key";
        }
        return "allkeys";
    }

    @ModelAttribute("items")
    public List<Item> getItems(){
        return itemService.getAllItems();
    }
}