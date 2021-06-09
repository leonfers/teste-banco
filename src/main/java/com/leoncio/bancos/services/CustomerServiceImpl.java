package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.CustomerDTO;
import com.leoncio.bancos.models.Customer;
import com.leoncio.bancos.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setCode(customerDTO.getCode());
        customerRepository.save(customer);
        customerDTO.setId(customer.getId());
        return customerDTO;
    }

    @Override
    public CustomerDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream().map(CustomerDTO::new).collect(Collectors.toList());
    }

    @Override
    public void destroy() {

    }
}
