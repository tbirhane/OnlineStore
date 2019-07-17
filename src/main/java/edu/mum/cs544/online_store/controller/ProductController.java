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
    public String getAll(Model model) {
        model.addAttribute("products", productService.findAll());
        return "productList";
    }


    @GetMapping("/findbyid/{id}")
    public String getProductById(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "productEdit";
    }

    @GetMapping("/addForm")
    public String getAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "productForm";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("product", product);
        return "redirect:detail";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(Product product) {
        productService.update(product);

        return "redirect:/products/list";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products/list";
    }

    @GetMapping("/detail")
    public String get(Model model) {

        return "productDetail";
    }

    @GetMapping(value = "/getProductPhoto")
//    public void productImage(HttpServletRequest request, HttpServletResponse response, Model model
//                             ) throws IOException {
//        long id = Long.parseLong(request.getParameter("id"));
//        Product product = null;
//        if (id != 0) {
//            product = this.productService.findById(id);
//        }
//        if (product != null && product.getImage() != null) {
//            response.setContentType("image/jpeg");
//            response.getOutputStream().write(product.getImage());
//        }
//        response.getOutputStream().close();
//    }
    public void showImage(@RequestParam("id") Long itemId, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {


        Product product = productService.findById(itemId);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(product.getImage());


        response.getOutputStream().close();
    }
}





