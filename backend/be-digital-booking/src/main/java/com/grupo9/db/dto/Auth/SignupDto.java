package com.grupo9.db.dto.Auth;
import com.grupo9.db.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SignupDto {

    @NotEmpty(message = "name is mandatory")
    private String name;

    @NotEmpty(message = "lastname is mandatory")
    private String lastname;

    @NotBlank(message = "email is mandatory")
    @Email(message = "email with wrong format")
    private String email;

    @NotBlank(message = "password is mandatory")
    @Size(min = 6)
    private String password;

    private Long locationId;
}