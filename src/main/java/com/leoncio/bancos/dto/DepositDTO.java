package com.leoncio.bancos.dto;

import com.leoncio.bancos.form.DepositForm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class DepositDTO  implements TransactionDTO {

    private Integer id;
    private String destinyAccountCode;
    private BigDecimal amount;
    private LocalDateTime date;

    public DepositDTO(DepositForm depositForm) {
        this.destinyAccountCode = depositForm.getDestinyAccountCode();
        this.amount = depositForm.getAmount();
    }

}
