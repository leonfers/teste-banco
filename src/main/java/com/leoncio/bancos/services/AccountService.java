package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.AccountDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    public AccountDTO save(AccountDTO accountDTO);

    public AccountDTO findById(Integer id);

    public List<AccountDTO> findAll();

    public void destroy();
}
