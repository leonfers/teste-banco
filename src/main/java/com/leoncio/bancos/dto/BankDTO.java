package com.leoncio.bancos.dto;

import com.leoncio.bancos.models.Bank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
public class BankDTO implements BaseDTO {

    private Integer id;
    private String code;
    private String name;
    private List<AccountDTO> accounts = new ArrayList<>();

    public BankDTO(Bank bank){
        this.id = bank.getId();
        this.code = bank.getCode();
        this.name = bank.getName();
    }

    @Override
    public String toString() {
        return "BankDTO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
