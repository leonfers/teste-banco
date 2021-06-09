package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.AccountDTO;
import com.leoncio.bancos.dto.BankStatementDTO;

import java.time.LocalDate;
import java.util.List;

public interface AccountService {

    public AccountDTO save(AccountDTO accountDTO);

    public AccountDTO findById(Integer id);

    public List<AccountDTO> findAll();

    public String destroy(int id);

    BankStatementDTO getBankStatementByAccountId(int id, LocalDate startDate, LocalDate endDate);
}
