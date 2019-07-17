package edu.mum.cs544.online_store.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
public class CustomerOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date orderDate;
    private Long orderNumber;
    @OneToOne
    private Address shippingAddress;
    @OneToMany
    @JoinColumn(name="order_id")
    private List<OrderLine> orderLineList;

}
