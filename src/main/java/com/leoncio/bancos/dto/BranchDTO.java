package com.leoncio.bancos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class BranchDTO  implements BaseDTO{

    private String code;
    private String bankCode;
    private String address;
    private List<AccountDTO> accounts;

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
