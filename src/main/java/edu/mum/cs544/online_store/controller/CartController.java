package edu.mum.cs544.online_store.controller;

import edu.mum.cs544.online_store.model.*;
import edu.mum.cs544.online_store.service.CustomerOrderService;
import edu.mum.cs544.online_store.service.ICustomerOrderService;
import edu.mum.cs544.online_store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/products/")
public class CartController {
    @Autowired
    private Gson gson;
    @Autowired
    private ProductService productService;
    @Autowired
    private ICustomerOrderService customerOrderService;

    //Add item to a cart
    @PostMapping(value = "addtocart", consumes = "application/json",produces = "application/json")
    public @ResponseBody OrderLine addToCart(@RequestBody OrderLine orderLine, HttpSession session){

        long productId = orderLine.getProduct().getId();
        int quantity = orderLine.getQuantity();

        Product product = productService.findById(productId);
        Cart cart = null;
        if(session.getAttribute("cart") == null){
            cart = new Cart();
        }else {
            cart = (Cart) session.getAttribute("cart");
        }
        cart.addProduct(product, quantity);

//        System.out.println("Hi cart");
//        List<OrderLine> items;
//        double subtotal = 0.0;
//        double currentSubTotal = orderLine.getProduct().getPrice()*orderLine.getQuantity();
//        if(session.getAttribute("cart") == null){
//            items = new ArrayList<>();
//            session.setAttribute("total", 0.0);
//        }
//        else {
//            items = (List<OrderLine>) session.getAttribute("cart");
//            subtotal = (double) session.getAttribute("total");
//        }
//        System.out.println(orderLine.getProduct().getName());
//        orderLine.setId(null);
//        items.add(orderLine);
//
//        Cart cart = new Cart();
//        cart.setOrderLines(items);
//        session.setAttribute("cartObject",cart);
//
//        session.setAttribute("total", (subtotal+currentSubTotal));
//
//        session.setAttribute("cart", items);
        session.setAttribute("cart",cart);
        return orderLine;
    }
    //Remove item from cart
    @PostMapping(value = "removeItem", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    ProductUtil removeItemCart(@RequestBody ProductUtil removedProduct, HttpSession session){

        long productId = removedProduct.getId();
        int quantity = removedProduct.getQuantity();

        Product product = productService.findById(productId);
        Cart cart = (Cart) session.getAttribute("cart");
        cart.removeProduct(product, quantity);
        removedProduct.setTotalPrice(cart.getTotalPrice());
        session.setAttribute("cart",cart);

//        System.out.println("Remove Item");
//        List<OrderLine> items = (List<OrderLine>) session.getAttribute("cart");
//        System.out.println("id = "+removedProduct.getId());
//        //remove element
//        double itemPrice =0.0;
//        for(OrderLine orderLine: items){
//            if(orderLine.getId().equals(removedProduct.getId())){
//                itemPrice = orderLine.getQuantity()* orderLine.getProduct().getPrice();
//                items.remove(orderLine);
//                break;
//            }
//        }
//        double subtotal = (double)session.getAttribute("total");
//        session.setAttribute("total", subtotal - itemPrice);
//        session.setAttribute("cart", items);
          return removedProduct;
    }



    @GetMapping(value = "checkout")
    public String checkOut(HttpSession session) {
        System.out.println("checkout");
        return "checkout/shippingForm";
    }

    @PostMapping(value = "checkout")
    public String addShippingAddress(Address address, HttpSession session){
        session.setAttribute("shippingAddres",address);
        return "redirect:paymentInfo";
    }

    @GetMapping(value = "paymentInfo")
    public String getPayment(){
        return "checkout/paymentInfo";
    }

    @PostMapping(value = "paymentInfo")
    public String addPayment(PaymentInfo paymentInfo, HttpSession session){

        session.setAttribute("paymentInfo",paymentInfo);

        Cart cart = (Cart) session.getAttribute("cart");
        Address address = (Address) session.getAttribute("shippingAddres");
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setOrderDate(new Date());
        customerOrder.setOrderLineList(cart.getOrderLines());
        customerOrder.setPaymentInfo(paymentInfo);
        customerOrder.setShippingAddress(address);

        customerOrderService.save(customerOrder);
        session.setAttribute("customerOrder",customerOrder);

//        session.setAttribute("cart",new ArrayList<OrderLine>());
        session.setAttribute("cart", new Cart());
        session.setAttribute("shippingAddress", new Address());
        session.setAttribute("total",0.0);
        //session.invalidate();
        return "redirect:/products/orderlist";
    }

//    @PostMapping(value = "placeOrder")
//    public String placeOrder(){
//
//    }



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
