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
public class AccountDTO implements BaseDTO {

    private Integer id;
    private String code;
    private String branchCode;
    private String customerCode;
    private BigDecimal balance;
    private LocalDateTime openingDate;

    public AccountDTO(AccountForm accountForm) {
        this.code = accountForm.getCode();
        this.branchCode = accountForm.getBranch_code();
        this.customerCode = accountForm.getCustomer_code();
    }

    public AccountDTO(Account account) {
        this.id = account.getId();
        this.code = account.getCode();
        this.balance = account.getBalance();
        this.customerCode = account.getCustomer().getCode();
        this.branchCode = account.getBranch().getCode();
        this.openingDate = account.getOpeningDate();
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", customerCode='" + customerCode + '\'' +
                '}';
    }
}
