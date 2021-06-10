package com.leoncio.bancos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WithdrawalDTO implements TransactionDTO {

    private Integer id;
    private Integer originAccountId;
    private BigDecimal amount;
    private LocalDateTime date;

    public WithdrawalDTO(WithdrawalForm withdrawalForm) {
        this.originAccountId = withdrawalForm.getOriginAccountId();
        this.amount = withdrawalForm.getAmount();
    }

    public WithdrawalDTO(Withdrawal withdrawal) {
        this.amount = withdrawal.getAmount();
        this.date = withdrawal.getDate();
        this.originAccountId = withdrawal.getOrigin().getId();
        this.id = withdrawal.getId();
    }

    @Override
    public LocalDateTime getDate() {
        return this.date;
    }

    @Override
    public int compareTo(TransactionDTO transactionDTO) {
        return getDate().compareTo(transactionDTO.getDate());
    }
}
