package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.CustomerDTO;
import com.leoncio.bancos.errorhandling.exceptions.DuplicateFoundException;
import com.leoncio.bancos.models.Customer;
import com.leoncio.bancos.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
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
        try {
            Customer customer = new Customer();
            customer.setName(customerDTO.getName());
            customer.setAddress(customerDTO.getAddress());
            customer.setCode(customerDTO.getCode());
            customerRepository.save(customer);
            customerDTO.setId(customer.getId());
            return customerDTO;
        } catch (ConstraintViolationException| DataIntegrityViolationException ex) {
            throw new DuplicateFoundException("Is not possible to create two customers with the same code");
        }
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
