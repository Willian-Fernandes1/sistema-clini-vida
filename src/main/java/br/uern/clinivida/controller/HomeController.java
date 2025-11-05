package br.uern.clinivida.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/","/index"})
    public String index(){ 
        return "index"; 
    }

    @GetMapping("/login")
    public String login(){ 
        return "login"; 
    }

    @GetMapping("/home")       // ✅ Página que o usuário verá pós-login
    public String home(){
        return "home";         // carrega templates/home.html
    }
}
