package com.example.jiuteiro.demo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    @NotBlank(message = "Username cannot be null or blank!") // validation to make sure cant be null
    private String username;
    @NotBlank(message = "Password cannot be null or blank!")
    private String password;

}
