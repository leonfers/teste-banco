package com.leoncio.bancos.dto;

import com.leoncio.bancos.form.TransferForm;
import com.leoncio.bancos.models.Transfer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class TransferDTO implements TransactionDTO, Comparable<TransactionDTO> {

    private Integer id;
    private Integer originAccountId;
    private Integer destinyAccountId;
    private BigDecimal amount;
    private LocalDateTime date;

    public TransferDTO(TransferForm transferForm) {
        this.originAccountId = transferForm.getOriginAccountId();
        this.destinyAccountId = transferForm.getDestinyAccountId();
        this.amount = transferForm.getAmount();
    }

    public TransferDTO(Transfer transfer) {
        this.amount = transfer.getAmount();
        this.date = transfer.getDate();
        this.originAccountId = transfer.getOrigin().getId();
        this.destinyAccountId = transfer.getDestiny().getId();
        this.id = transfer.getId();
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
