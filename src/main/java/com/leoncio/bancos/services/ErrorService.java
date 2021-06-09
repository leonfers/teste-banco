package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.ErrorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ErrorService {

    public ErrorDTO findByCode(String code);

    public List<ErrorDTO> findAll();

}
