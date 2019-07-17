package edu.mum.cs544.online_store.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
public class RegistrationFormDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
