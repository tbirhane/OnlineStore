package edu.mum.cs544.online_store.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class AccountFormDTO {
    @NonNull
    private String userName;
    private String oldPassword;
    private String newPassword;
}
