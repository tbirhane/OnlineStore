package edu.mum.cs544.online_store.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
//@RequiredArgsConstructor
public class Cart {
    private List<OrderLine> orderLines;

    public Cart(){
        orderLines = new ArrayList<>();
    }
    // public void addProduct(Product product, int quantity) {
        // find an orderline in the cart containing the product
        // if found, increase quantity
        // otherwise, create new orderline with this product and specified quantity

    //}
    public OrderLine addProduct(Product product, int quantity){
        OrderLine orderLine = null;
        for(OrderLine l:orderLines){
           if(l.getProduct().getId()  == product.getId()){
               orderLine = l;
               break;
           }
        }
        if(orderLine == null){
            orderLine = new OrderLine();
            orderLine.setProduct(product);
            orderLine.setQuantity(quantity);
            orderLines.add(orderLine);
        }
        else {
            orderLine.setQuantity(orderLine.getQuantity()+quantity);
        }
        return orderLine;
    }

    public double  getTotalPrice(){
        double total = 0.0;
        for (OrderLine lines: orderLines){
            total += lines.getProduct().getPrice()*lines.getQuantity();
        }
        return total;
    }

    public void removeProduct(Product product, int quantity) {
        OrderLine orderLine = null;
        for(OrderLine l:orderLines){
            if(l.getProduct().getId()  == product.getId()){
                orderLine = l;
                break;
            }
        }
        if(orderLine != null) {
            orderLine.setQuantity(orderLine.getQuantity() - quantity);
            if(orderLine.getQuantity() < 1)
                orderLines.remove(orderLine);
        }
    }
}
