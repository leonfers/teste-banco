package com.leoncio.bancos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class WithdrawalDTO  implements TransactionDTO {

    private String accountCode;
    private String originAccount;
    private String amount;
    private LocalDateTime date;

    @Override
    public String toString() { //TODO
        return "WithdrawalDTO{" +
                "accountCode='" + accountCode + '\'' +
                ", originAccount='" + originAccount + '\'' +
                ", amount='" + amount + '\'' +
                ", date=" + date +
                '}';
    }
}
