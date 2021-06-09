package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.AccountDTO;
import com.leoncio.bancos.dto.BankStatementDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface AccountService {

    public AccountDTO save(AccountDTO accountDTO);

    public AccountDTO findById(Integer id);

    public List<AccountDTO> findAll();

    public void destroy();

    BankStatementDTO getBankStatementByAccountId(int id, LocalDate startDate, LocalDate endDate);
}
