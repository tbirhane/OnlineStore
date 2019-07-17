package edu.mum.cs544.online_store.controller;

import edu.mum.cs544.online_store.model.Product;
import edu.mum.cs544.online_store.service.ProductService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String getAll(Model model, HttpSession session) {
        model.addAttribute("products", productService.findAll());
        session.setAttribute("total",0.0);
        return "product/productList";
    }

    @GetMapping("/orderlist")
    public String getOrder(Model model) {
       // model.addAttribute("customerOrder", productService.findAll());

        return "checkout/orderConfirmation";
    }
}





