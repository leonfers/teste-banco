package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.BankDTO;

import java.util.List;

public interface BankService {

    BankDTO save(BankDTO bankDTO);

    BankDTO findById(Integer id);

    List<BankDTO> findAll();

    String destroy(Integer id);

}
