package edu.mum.cs544.online_store.controller;

import edu.mum.cs544.online_store.model.Account;
import edu.mum.cs544.online_store.model.User;
import edu.mum.cs544.online_store.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public String redirect(Principal principal, Model model){
//        if(principal != null) {
//            String userName = principal.getName();
//            Account account = accountService.findByUserName(userName);
//            if (account.getRole().equals("ROLE_ADMIN"))
//                return "redirect:/admin/";
//        }
//        return "redirect:/products/list";
        String messsage = "none";
        if (principal != null)
            messsage = principal.getName();
        model.addAttribute("message",messsage);
        return "test";
    }


    @GetMapping(value = "login")
    public String getLonin(){
        return "account/login";
    }
}
