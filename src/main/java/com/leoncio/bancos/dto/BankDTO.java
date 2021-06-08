package com.leoncio.bancos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class BankDTO implements BaseDTO {

    private Integer id;
    private String code;
    private String bankCode;
    private String address;
    private List<AccountDTO> accounts = new ArrayList<>();

    @Override
    public String toString() {
        return "BankDTO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", address='" + address + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
