package com.leoncio.bancos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.leoncio.bancos.form.BankForm;
import com.leoncio.bancos.models.Bank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankDTO {

    private Integer id;
    private String code;
    private String name;

    public BankDTO(BankForm bankForm) {
        this.code = bankForm.getCode();
        this.name = bankForm.getName();
    }

    public BankDTO(Bank bank) {
        this.id = bank.getId();
        this.code = bank.getCode();
        this.name = bank.getName();
    }

}
