package com.leoncio.bancos.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountForm {

    @NotNull(message = "Branch id is mandatory")
    private Integer branchId;

    private Integer userId;

}
