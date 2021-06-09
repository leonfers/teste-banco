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
public class TransferDTO implements TransactionDTO, Comparable<TransactionDTO>{

    private Integer id;
    private String originAccountCode;
    private String destinyAccountCode;
    private BigDecimal amount;
    private LocalDateTime date;

    public TransferDTO(TransferForm transferForm) {
        this.originAccountCode = transferForm.getOriginAccountCode();
        this.destinyAccountCode = transferForm.getDestinyAccountCode();
        this.amount = transferForm.getAmount();
    }

    public TransferDTO(Transfer transfer) {
        this.amount = transfer.getAmount();
        this.date = transfer.getDate();
        this.originAccountCode = transfer.getOrigin().getCode();
        this.destinyAccountCode = transfer.getDestiny().getCode();
        this.id = transfer.getId();
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
