package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.ErrorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErrorServiceImpl implements ErrorService{

    @Override
    public ErrorDTO findByCode(String code) {
        return null;
    }

    @Override
    public List<ErrorDTO> findAll() {
        return null;
    }
}
