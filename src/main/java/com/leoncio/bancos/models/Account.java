package com.leoncio.bancos.models;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "branch_id"})})
public class Account {
    private Integer id;
    private Branch branch;
    private LocalDateTime openingDate;
    private BigDecimal balance = BigDecimal.ZERO;
    private Integer version;
    private User user;

    private List<Withdrawal> withdrawals = new ArrayList<>();
    private List<Transfer> incomingTransfers = new ArrayList<>();
    private List<Transfer> outgoingTransfers = new ArrayList<>();
    private List<Deposit> deposits = new ArrayList<>();

    public Account(Branch branch, LocalDateTime openingDate, User user) {
        this.branch = branch;
        this.openingDate = openingDate;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDateTime openingDate) {
        this.openingDate = openingDate;
    }

    public BigDecimal getBalance() {
        if (balance == null) {
            balance = BigDecimal.ZERO;
        }
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Version
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @OneToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @OneToMany(mappedBy = "origin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Withdrawal> getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(List<Withdrawal> withdrawals) {
        this.withdrawals = withdrawals;
    }

    @OneToMany(mappedBy = "destiny", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Transfer> getIncomingTransfers() {
        return incomingTransfers;
    }

    public void setIncomingTransfers(List<Transfer> transfers) {
        this.incomingTransfers = transfers;
    }

    @OneToMany(mappedBy = "origin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Transfer> getOutgoingTransfers() {
        return outgoingTransfers;
    }

    public void setOutgoingTransfers(List<Transfer> outgoingTransfers) {
        this.outgoingTransfers = outgoingTransfers;
    }

    @OneToMany(mappedBy = "destiny", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Deposit> deposits) {
        this.deposits = deposits;
    }
}
