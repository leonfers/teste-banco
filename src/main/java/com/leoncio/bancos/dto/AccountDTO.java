package com.leoncio.bancos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.leoncio.bancos.form.AccountForm;
import com.leoncio.bancos.models.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDTO {

    private Integer branchId;
    private Integer id;
    private String branchCode;
    private Integer userId;
    private BigDecimal balance;
    private LocalDateTime openingDate;
    private String bankCode;
    private String bankName;

    public AccountDTO(AccountForm accountForm) {
        this.branchId = accountForm.getBranchId();
        this.userId = accountForm.getUserId();
    }

    public AccountDTO(Account account) {
        this.id = account.getId();
        if(account.getUser() != null){
            this.userId = account.getUser().getId();
        }
        this.balance = account.getBalance();
        this.branchCode = account.getBranch().getCode();
        this.openingDate = account.getOpeningDate();
        this.bankCode = account.getBranch().getBank().getCode();
        this.bankName = account.getBranch().getBank().getName();
    }
}
