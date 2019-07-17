package edu.mum.cs544.online_store.controller;

import edu.mum.cs544.online_store.model.Cart;
import edu.mum.cs544.online_store.model.OrderLine;
import edu.mum.cs544.online_store.model.Product;
import edu.mum.cs544.online_store.model.ProductUtil;
import edu.mum.cs544.online_store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products/")
public class CartController {
    @Autowired
    private Gson gson;
    @Autowired
    private ProductService productService;
    //Add item to a cart
    @PostMapping(value = "addtocart", consumes = "application/json",produces = "application/json")
    public @ResponseBody OrderLine addToCart(@RequestBody OrderLine orderLine, HttpSession session){
        System.out.println("Hi cart");
        List<OrderLine> items;
        double subtotal = 0.0;
        double currentSubTotal = orderLine.getProduct().getPrice()*orderLine.getQuantity();
        if(session.getAttribute("cart") == null){
            items = new ArrayList<>();
            session.setAttribute("total", 0.0);
        }
        else {
            items = (List<OrderLine>) session.getAttribute("cart");
            subtotal = (double) session.getAttribute("total");
        }
        System.out.println(orderLine.getProduct().getName());
        items.add(orderLine);

        Cart cart = new Cart();
        cart.setOrderLines(items);
        session.setAttribute("cartObject",cart);

        session.setAttribute("total", (subtotal+currentSubTotal));
        session.setAttribute("cart", items);
        return orderLine;
    }
    //Remove item from cart
    @PostMapping(value = "removeItem", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ProductUtil removeItemCart(@RequestBody ProductUtil removedProduct, HttpSession session){
        System.out.println("Remove Item");
        List<OrderLine> items = (List<OrderLine>) session.getAttribute("cart");
        System.out.println("id = "+removedProduct.getId());
        //remove element
        double itemPrice =0.0;
        for(OrderLine orderLine: items){
            if(orderLine.getId().equals(removedProduct.getId())){
                itemPrice = orderLine.getQuantity()* orderLine.getProduct().getPrice();
                items.remove(orderLine);
                break;
            }
        }
        double subtotal = (double)session.getAttribute("total");
        session.setAttribute("total", subtotal - itemPrice);
        session.setAttribute("cart", items);
        return removedProduct;
    }



    @GetMapping(value = "checkout")
    public String checkOut(HttpSession session) {
        System.out.println("checkout");

        Long id = new Long(911010);

//        if(id.equals(checkout.getId())){
//            System.out.println("Checked!");
//        }
        return "checkout";

    }

    @PostMapping(value = "updateCart", consumes = "application/json", produces = "application/json")
    public @ResponseBody Product updateCart(@RequestBody ProductUtil productInfo, HttpSession session){
        System.out.println("Update Item");
        List<Product> items = (List<Product>) session.getAttribute("cart");
        System.out.println("id = "+productInfo.getId());
        //remove element
        Product update = null;
        for(Product p: items){
            if(p.getId().equals(productInfo.getId())){
               // items.remove(p);
                p.setQuantity(productInfo.getQuantity());
                update = p;
                break;
            }
        }

        session.setAttribute("cart", items);
        return update;
    }

}
