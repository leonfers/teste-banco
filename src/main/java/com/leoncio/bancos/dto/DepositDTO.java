package com.leoncio.bancos.dto;

import com.leoncio.bancos.form.DepositForm;
import com.leoncio.bancos.models.Deposit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class DepositDTO implements TransactionDTO, Comparable<TransactionDTO> {

    private Integer id;
    private Integer destinyAccountId;
    private BigDecimal amount;
    private LocalDateTime date;

    public DepositDTO(DepositForm depositForm) {
        this.destinyAccountId = depositForm.getDestinyAccountId();
        this.amount = depositForm.getAmount();
    }

    public DepositDTO(Deposit deposit) {
        this.amount = deposit.getAmount();
        this.date = deposit.getDate();
        this.destinyAccountId = deposit.getDestiny().getId();
        this.id = deposit.getId();
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
