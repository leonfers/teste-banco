package com.leoncio.bancos.dto;

import com.leoncio.bancos.form.WithdrawalForm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class WithdrawalDTO  implements TransactionDTO {

    private Integer id;
    private String originAccountCode;
    private BigDecimal amount;
    private LocalDateTime date;

    public WithdrawalDTO(WithdrawalForm withdrawalForm) {
        this.originAccountCode = withdrawalForm.getOriginAccountCode();
        this.amount = withdrawalForm.getAmount();
    }
}
