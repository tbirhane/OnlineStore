package edu.mum.cs544.online_store.controller;

import edu.mum.cs544.online_store.model.Product;
import edu.mum.cs544.online_store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/admin/products")
public class AdminProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String getAll(Model model) {
        model.addAttribute("products", productService.findAll());
        return "admin/productList";
    }

    @GetMapping("/findbyid/{id}")
    public String getProductById(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "admin/productEdit";
    }

    @GetMapping("/addForm")
    public String getAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "productForm";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
       try {
           product.setImageStr(Base64Utils.encodeToString(product.getProductImage().getBytes()));
           productService.save(product);
           redirectAttributes.addFlashAttribute("product", product);
           return "redirect:detail";
       }catch (Exception ex){
           ex.printStackTrace();
           return "redirect:admin/products/addForm";
       }
    }

    @PostMapping("/update/{id}")
    public String updateProduct(Product product,RedirectAttributes redirectAttributes) {
        try {
            product.setImageStr(Base64Utils.encodeToString(product.getProductImage().getBytes()));
            productService.update(product);
            redirectAttributes.addFlashAttribute("product", product);
            return "redirect:/admin/products/list";
        }catch (Exception ex){
            ex.printStackTrace();
            return "redirect:admin/products/addForm";
        }

    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/admin/products/list";
    }

    @GetMapping("/detail")
    public String get(Model model) {
        return "productDetail";
    }


}
