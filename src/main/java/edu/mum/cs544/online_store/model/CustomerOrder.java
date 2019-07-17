package edu.mum.cs544.online_store.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date orderDate;
    @OneToOne(cascade = CascadeType.ALL)
    private Address shippingAddress;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="order_id")
    private List<OrderLine> orderLineList;
    @OneToOne(cascade = CascadeType.ALL)
    private PaymentInfo paymentInfo;

}
