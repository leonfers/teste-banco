package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.BankDTO;
import com.leoncio.bancos.models.Bank;
import com.leoncio.bancos.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
        Bank bank = new Bank();
        bank.setCode(bankDTO.getCode());
        bank.setName(bankDTO.getName());
        bankRepository.save(bank);
        return new BankDTO(bank);
    }

    @Override
    public BankDTO findById(Integer id) {
        Optional<Bank> optionalBank = bankRepository.findById(id);
        if(optionalBank.isPresent()){
            return new BankDTO(optionalBank.get());
        }else{
            throw new EntityNotFoundException("Banco não encontrado!");
        }

    }

    @Override
    public List<BankDTO> findAll() {
        return bankRepository.findAll().stream()
                .map(BankDTO::new).collect(Collectors.toList());
    }

    @Override
    public void destroy(Integer id) {
        bankRepository.deleteById(id);
    }
}
