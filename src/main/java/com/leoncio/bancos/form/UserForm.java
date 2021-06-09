package com.leoncio.bancos.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
public class UserForm {

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email does not have a valid format")
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;

}
