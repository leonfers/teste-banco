package com.leoncio.bancos.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class WithdrawalForm implements TransactionForm {

    private String originAccountCode;
    private BigDecimal amount;
    private LocalDateTime date;

    @Override
    public String toString() { //TODO
        return "WithdrawalDTO{" +
                ", originAccount='" + originAccountCode + '\'' +
                ", amount='" + amount + '\'' +
                ", date=" + date +
                '}';
    }
}
