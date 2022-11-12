package com.grupo9.db.dto.Auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class LoginDto {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}