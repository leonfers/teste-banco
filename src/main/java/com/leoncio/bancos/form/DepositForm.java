package com.leoncio.bancos.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class DepositForm implements TransactionForm {

    private String destinyAccountCode;
    private BigDecimal amount;
    private LocalDateTime date;

    @Override
    public String toString() { //TODO
        return "TransferDTO{" +
                ", targetAccount='" + destinyAccountCode + '\'' +
                ", amount='" + amount + '\'' +
                ", date=" + date +
                '}';
    }


}
