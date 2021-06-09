package com.leoncio.bancos.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class BranchForm implements BaseForm {

    private String code;
    private String bankCode;
    private String address;
    private List<AccountForm> accounts;

    @Override
    public String toString() {
        return "BranchDTO{" +
                "code='" + code + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", address='" + address + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
