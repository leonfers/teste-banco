package com.leoncio.bancos.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class BankStatementDTO {

    private String accountCode;
    private List<WithdrawalDTO> withdrawals;
    private List<DepositDTO> deposits;
    private List<TransferDTO> transfers;
    private LocalDate startDate;
    private LocalDate endDate;

    public List<TransactionDTO> getTimeline(){
        throw new UnsupportedOperationException();
    }

    public BigDecimal getTotal(){//TODO
        throw new UnsupportedOperationException();
    }

    public BigDecimal getCredit(){//TODO
        throw new UnsupportedOperationException();
    }

    public BigDecimal getDebit(){//TODO
        throw new UnsupportedOperationException();
    }

}
