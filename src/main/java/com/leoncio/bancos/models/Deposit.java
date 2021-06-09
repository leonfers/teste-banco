package com.leoncio.bancos.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("deposit")
public class Deposit extends Transaction {

    private Account destiny;
    private BigDecimal amount;
    private LocalDateTime date;

    @ManyToOne
    public Account getDestiny() {
        return destiny;
    }

    public void setDestiny(Account target) {
        this.destiny = target;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
