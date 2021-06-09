package com.leoncio.bancos.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
public class BankForm {

    public BankForm(@NotBlank(message = "Code is mandatory") String code, @NotBlank(message = "Name is mandatory") String name) {
        this.code = code;
        this.name = name;
    }

    @NotBlank(message = "Code is mandatory")
    private String code;

    @NotBlank(message = "Name is mandatory")
    private String name;

}
