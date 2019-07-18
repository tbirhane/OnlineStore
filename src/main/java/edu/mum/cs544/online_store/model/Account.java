package edu.mum.cs544.online_store.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String username;
    @NonNull
    private String password;
    @NonNull
    private String role;


    public Account(Account account) {
        this.username = account.getUsername();
        this.password = account.getPassword();
        this.role = account.getRole();

    }
}
