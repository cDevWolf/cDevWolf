package com.example.passwordapp.main.controllers.login.actions;

import com.example.passwordapp.models.entity.User;
import com.example.passwordapp.models.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class LoginActions {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(Model model, Principal principal, RedirectAttributes flash){
        if(principal!=null){
            flash.addAttribute("info", "You've in a curren session");
            return "redirect:/v1/";
        }
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerNewAccount(User user, BindingResult result, Model model, @RequestParam String passwordConfirm){
        if(!passwordConfirm.equals(user.getPassword())){
            model.addAttribute("info_error", "Password don't matched");
            return "register";
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setRole("USER_ROLE");
        userService.insertUser(user);
        model.addAttribute("info_new_account", "New account has been created");
        return "login";
    }
}
