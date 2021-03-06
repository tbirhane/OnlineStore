package edu.mum.cs544.online_store.controller;

import edu.mum.cs544.online_store.model.CustomerOrder;
import edu.mum.cs544.online_store.model.Product;
import edu.mum.cs544.online_store.service.AccountService;
import edu.mum.cs544.online_store.service.CustomerOrderService;
import edu.mum.cs544.online_store.service.ProductService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.sql.Blob;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerOrderService customerOrderService;
    @Autowired
    private AccountService accountService;

    @GetMapping("/list")
    public String getAll(Model model, HttpSession session, Principal principal) {
        boolean loggedIn = false;
        long id = -1;

        if(principal != null) {
            loggedIn = true;
            id = accountService.findByUserName(principal.getName()).getId();
        }

        model.addAttribute("loggedIn",loggedIn);
        model.addAttribute("userId",id);
        model.addAttribute("products", productService.findAll());
        //session.setAttribute("total",0.0);
        return "product/productList";
    }

    @GetMapping("/orderlist")
    public String getOrder(Model model, HttpSession session) {
        model.addAttribute("customerOrder", session.getAttribute("customerOrder"));

        return "checkout/orderConfirmation";
    }
}





