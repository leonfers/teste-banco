package com.leoncio.bancos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class DepositDTO  implements TransactionDTO {

    private String accountCode;
    private String targetAccount;
    private String amount;
    private LocalDateTime date;

    @Override
    public String toString() { //TODO
        return "TransferDTO{" +
                "accountCode='" + accountCode + '\'' +
                ", targetAccount='" + targetAccount + '\'' +
                ", amount='" + amount + '\'' +
                ", date=" + date +
                '}';
    }


}
