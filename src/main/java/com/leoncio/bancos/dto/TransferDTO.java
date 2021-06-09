package com.leoncio.bancos.dto;

import com.leoncio.bancos.form.TransferForm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class TransferDTO  implements TransactionDTO {

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

    @Override
    public String toString() { //TODO
        return "TransferDTO{" +
                ", originAccount='" + originAccountCode + '\'' +
                ", targetAccount='" + destinyAccountCode + '\'' +
                ", amount='" + amount + '\'' +
                ", date=" + date +
                '}';
    }
}
