package com.leoncio.bancos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AccountDTO implements BaseDTO {

    private Integer id;
    private String code;
    private String name;
    private List<BranchDTO> branches = new ArrayList<>();
    private List<CustomerDTO> customers = new ArrayList<>();
    private List<AccountDTO> accounts = new ArrayList<>();



    @Override
    public String toString() {
        return "AccountDTO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", branches=" + branches +
                ", customers=" + customers +
                ", accounts=" + accounts +
                '}';
    }
}
