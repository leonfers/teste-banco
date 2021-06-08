package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.CustomerDTO;
import com.leoncio.bancos.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public CustomerDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<CustomerDTO> findAll() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
