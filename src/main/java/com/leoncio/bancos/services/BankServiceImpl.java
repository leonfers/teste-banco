package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.BankDTO;
import com.leoncio.bancos.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService{

    private final BankRepository bankRepository;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public BankDTO save(BankDTO bankDTO) {
        return null;
    }

    @Override
    public BankDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<BankDTO> findAll() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
