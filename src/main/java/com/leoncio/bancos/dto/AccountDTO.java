package com.leoncio.bancos.dto;

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
public class AccountDTO {

    private Integer id;
    private String branchCode;
    private Integer userId;
    private BigDecimal balance;
    private LocalDateTime openingDate;

    public AccountDTO(AccountForm accountForm) {
        this.branchCode = accountForm.getBranch_code();
    }

    public AccountDTO(Account account) {
        this.id = account.getId();
        this.userId = account.getUser().getId();
        this.balance = account.getBalance();
        this.userId = account.getUser().getId();
        this.branchCode = account.getBranch().getCode();
        this.openingDate = account.getOpeningDate();
    }
}
