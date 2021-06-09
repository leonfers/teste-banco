package com.leoncio.bancos.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountForm implements BaseForm {

    private String code;
    private String branch_code;
    private String customer_code;

    @Override
    public String toString() {
        return "AccountForm{" +
                ", code='" + code + '\'' +
                ", branch_code='" + branch_code + '\'' +
                ", customer_code='" + customer_code + '\'' +
                '}';
    }
}
