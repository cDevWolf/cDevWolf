package com.example.passwordapp.main.controllers.hub.keys;

import com.example.passwordapp.models.entity.Item;
import com.example.passwordapp.models.entity.Key;
import com.example.passwordapp.models.entity.User;
import com.example.passwordapp.models.security.UserDetails.UserForUserDetails;
import com.example.passwordapp.models.service.item.ItemService;
import com.example.passwordapp.models.service.key.KeyService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.codec.ByteArrayDecoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.keygen.Base64StringKeyGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import javax.validation.Valid;
import javax.websocket.Decoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/keys")
@SessionAttributes("items")
public class KeysController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private KeyService keyService;
    @GetMapping("/all-keys")
    public String goToAllKeys(Model model){
        User user = getUserInfo();
        List<Key> allkeys = new ArrayList<>();
        allkeys = keyService.getAllKeysByKeyListId(user.getKeyList());
        for (Key key : allkeys){
            String pass = new String(java.util.Base64.getDecoder().decode(key.getPassword()), StandardCharsets.UTF_8);
            key.setPassword(pass);
        }
        model.addAttribute("allkeys", allkeys);
        return "allkeys";
    }
    @GetMapping("/register-key")
    private String registerNewKey(Model model, @RequestParam(required = false) Long id){
        Key key = new Key();
        if(id!=null){
            key = keyService.getKeyById(id);
        }
        model.addAttribute("key", key);
        return "register-key";
    }


    @PostMapping("/register-key")
    private String registerKeyPost(Model model, @Valid Key key, BindingResult result, @RequestParam String passwordConf){
        if(result.hasErrors() || !passwordConf.equals(key.getPassword())){
            model.addAttribute("info_error_password", true);
            model.addAttribute("key", key);
            return "/register-key";
        }


        User user = getUserInfo();
        key.setPassword(Base64.encodeBase64String(key.getPassword().getBytes()));
        key.setKeyList(user.getKeyList());
        keyService.insertKey(key);

        return "redirect:/keys/all-keys";
    }

    @ModelAttribute("items")
    public List<Item> getItems(){
        return itemService.getAllItems();
    }

    private User getUserInfo(){
        UserForUserDetails user =(UserForUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userDetail = user.getUser();
        return userDetail;
    }
}