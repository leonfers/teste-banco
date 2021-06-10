package com.leoncio.bancos.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankStatementDTO {

    private Integer accountId;
    private String branchCode;
    private String bankCode;
    private String bankName;
    private List<WithdrawalDTO> withdrawals;
    private List<DepositDTO> deposits;
    private List<TransferDTO> transfers;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal currentBalance;
    private LocalDateTime date;

    public List<TransactionDTO> getTimeline() {
        List<TransactionDTO> transactions = new ArrayList<>();
        transactions.addAll(withdrawals);
        transactions.addAll(deposits);
        transactions.addAll(transfers);
        Collections.sort(transactions);
        return transactions;
    }

    public BigDecimal getTotal() {
        return getCredit().subtract(getDebit());
    }

    public BigDecimal getCredit() {
        BigDecimal totalDeposits = deposits.stream()
                .map(DepositDTO::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal totalIncomingTransfers = transfers.stream()
                .filter(transferDTO -> transferDTO.getDestinyAccountId().equals(this.accountId))
                .map(TransferDTO::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalDeposits.add(totalIncomingTransfers);
    }

    public BigDecimal getDebit() {
        BigDecimal totalWithdrawals = withdrawals.stream()
                .map(WithdrawalDTO::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal totalOutgoingTransfers = transfers.stream()
                .filter(transferDTO -> transferDTO.getOriginAccountId().equals(this.accountId))
                .map(TransferDTO::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return totalWithdrawals.add(totalOutgoingTransfers);
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
