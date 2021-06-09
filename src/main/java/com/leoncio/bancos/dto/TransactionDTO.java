package com.leoncio.bancos.dto;

import java.time.LocalDateTime;

public interface TransactionDTO extends Comparable<TransactionDTO>{

    LocalDateTime getDate();
}
