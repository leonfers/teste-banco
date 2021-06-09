package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.ErrorDTO;

import java.util.List;

public interface ErrorService {

    ErrorDTO findByCode(String code);

    List<ErrorDTO> findAll();

}
