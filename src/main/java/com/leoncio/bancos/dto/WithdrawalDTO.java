package com.leoncio.bancos.dto;

import com.leoncio.bancos.form.WithdrawalForm;
import com.leoncio.bancos.models.Withdrawal;
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

    public WithdrawalDTO(Withdrawal withdrawal) {
        this.amount = withdrawal.getAmount();
        this.date = withdrawal.getDate();
        this.originAccountCode = withdrawal.getOrigin().getCode();
        this.id = withdrawal.getId();
    }

    @Override
    public LocalDateTime getDate(){
        return this.date;
    }

    @Override
    public int compareTo(TransactionDTO transactionDTO) {
        return getDate().compareTo(transactionDTO.getDate());
    }
}
