package com.leoncio.bancos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO implements BaseDTO {

    private String code;
    private String name;
    private String address;
    private List<AccountDTO> accounts;

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
