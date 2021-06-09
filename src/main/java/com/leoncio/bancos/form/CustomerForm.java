package com.leoncio.bancos.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CustomerForm implements BaseForm {

    private String code;
    private String name;
    private String address;
    private List<AccountForm> accounts;

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
