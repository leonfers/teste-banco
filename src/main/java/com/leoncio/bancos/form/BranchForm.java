package com.leoncio.bancos.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
public class BranchForm {

    @NotBlank(message = "Code is mandatory")
    private String code;

    @NotBlank(message = "Bank code is mandatory")
    private String bankCode;
}
