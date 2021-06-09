package com.leoncio.bancos.form;

import com.leoncio.bancos.models.Bank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@NoArgsConstructor
public class BankForm implements BaseForm {

    @NotBlank(message = "code: Código é obrigatório")
    private String code;

    @NotBlank(message = "name: Nome é obrigatório")
    private String name;

    public BankForm(Bank bank){
        this.code = bank.getCode();
        this.name = bank.getName();
    }

    @Override
    public String toString() {
        return "BankForm{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
