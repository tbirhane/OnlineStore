package edu.mum.cs544.online_store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/hi")
    public String get(){
        return "index";
    }

}
