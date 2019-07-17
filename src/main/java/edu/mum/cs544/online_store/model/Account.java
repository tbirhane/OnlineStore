package edu.mum.cs544.online_store.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String userName;
    @NonNull
    private String password;
    @NonNull
    private String role;

}
