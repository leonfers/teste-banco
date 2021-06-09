package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.BankDTO;
import com.leoncio.bancos.errorhandling.exceptions.DuplicateFoundException;
import com.leoncio.bancos.models.Bank;
import com.leoncio.bancos.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public BankDTO save(BankDTO bankDTO) {
        try {
            Bank bank;
            if(bankDTO.getId()==null){
                bank = new Bank();
            }else{
                bank = bankRepository.getById(bankDTO.getId());
            }
            bank.setCode(bankDTO.getCode());
            bank.setName(bankDTO.getName());
            bankRepository.save(bank);
            return new BankDTO(bank);
        } catch (ConstraintViolationException| DataIntegrityViolationException ex) {
            throw new DuplicateFoundException("Is not possible to create two banks with the same name or the same code");
        }
    }

    @Override
    public BankDTO findById(Integer id) {
        Optional<Bank> optionalBank = bankRepository.findById(id);
        if (optionalBank.isPresent()) {
            return new BankDTO(optionalBank.get());
        } else {
            throw new EntityNotFoundException("Banco não encontrado!");
        }

    }

    @Override
    public List<BankDTO> findAll() {
        return bankRepository.findAll().stream()
                .map(BankDTO::new).collect(Collectors.toList());
    }

    @Override
    public String destroy(Integer id) {
        bankRepository.deleteById(id);
        return "Bank deleted";
    }
}
