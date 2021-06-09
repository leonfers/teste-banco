package com.leoncio.bancos.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class BankStatementForm implements BaseForm {

    private String accountCode;
    private List<WithdrawalForm> withdrawals;
    private List<DepositForm> deposits;
    private List<TransferForm> transfers;
    private LocalDate startDate;
    private LocalDate endDate;

    public List<TransactionForm> getTimeline(){ //TODO
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
