package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.AccountDTO;
import com.leoncio.bancos.repositories.AccountRepository;
import com.leoncio.bancos.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        return null;
    }

    @Override
    public AccountDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<AccountDTO> findAll() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
