package edu.mum.cs544.online_store.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@RequiredArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    @OneToOne
    private Address address;
    @OneToOne
    private Account account;
    @Transient
    private Cart cart;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Order> orders;


}
