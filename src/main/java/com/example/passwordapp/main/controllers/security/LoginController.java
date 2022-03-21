package com.example.passwordapp.main.controllers.security;

import com.example.passwordapp.models.entity.KeyList;
import com.example.passwordapp.models.entity.User;
import com.example.passwordapp.models.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false)String error,
                            @RequestParam(required = false)String logout,
                            Model model, Principal principal, RedirectAttributes flash){

        if(principal != null){
            flash.addAttribute("info", "You've in a curren session");
            return "redirect:/v1/";
        }
        if(error!=null){
            model.addAttribute("info_error", "Credenciales incorrectas, contraseña o usuario incorrectos.");
        }
        if(logout!=null){
            model.addAttribute("info_logout", "Sesión cerrada correctamente");
        }
        return "login";
    }
}
