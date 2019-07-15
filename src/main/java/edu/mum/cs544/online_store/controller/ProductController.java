package edu.mum.cs544.online_store.controller;

import edu.mum.cs544.online_store.model.Product;
import edu.mum.cs544.online_store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("products", productService.findAll());
        return "productList";
    }

    @GetMapping("/detail")
    public String getProductDetail(){
        return "productDetail";
    }

    @GetMapping("/{id}")
    public String getProductById(@PathVariable  long id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(productService.findById(id));
        return "redirect:detail";
    }

    @GetMapping("/edit")
    public String getProductForm(Model model) {
        if (!model.containsAttribute("product"))
            model.addAttribute("product", new Product());
        return "productForm";
    }

    @GetMapping("/add")
    public String getAddForm(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("action", "Add");
        return "redirect:edit";
    }

    @GetMapping("/update")
    public String getUpdateForm(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("action", "Update");
        return "redirect:edit";
    }


    @PostMapping("/edit")
    public String saveProduct(Product product, RedirectAttributes redirectAttributes) {
        String s = "test";
        productService.save(product);
        redirectAttributes.addFlashAttribute("product", product);
        return "redirect:detail";
    }



}
