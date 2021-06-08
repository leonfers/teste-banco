package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.BankDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankService {

    public BankDTO save(BankDTO bankDTO);

    public BankDTO findById(Integer id);

    public List<BankDTO> findAll();

    public void destroy();

}
