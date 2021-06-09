package com.leoncio.bancos.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class AccountForm {

    @NotBlank(message = "Code is mandatory")
    private String code;

    @NotBlank(message = "Branch code is mandatory")
    private String branch_code;

    @NotBlank(message = "Customer code is mandatory")
    private String customer_code;
}
