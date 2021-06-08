package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    public CustomerDTO save(CustomerDTO customerDTO);

    public CustomerDTO findById(Integer id);

    public List<CustomerDTO> findAll();

    public void destroy();
}
