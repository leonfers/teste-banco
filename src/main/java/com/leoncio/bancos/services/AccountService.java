package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.AccountDTO;
import com.leoncio.bancos.dto.BankStatementDTO;

import java.time.LocalDate;
import java.util.List;

public interface AccountService {

    AccountDTO save(AccountDTO accountDTO);

    AccountDTO findById(Integer id);

    List<AccountDTO> findAll();

    String destroy(int id);

    BankStatementDTO getBankStatementByAccountId(int id, LocalDate startDate, LocalDate endDate);
}
