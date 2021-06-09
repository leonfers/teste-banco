package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.BranchDTO;
import com.leoncio.bancos.errorhandling.exceptions.DuplicateFoundException;
import com.leoncio.bancos.models.Bank;
import com.leoncio.bancos.models.Branch;
import com.leoncio.bancos.repositories.BankRepository;
import com.leoncio.bancos.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final BankRepository bankRepository;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, BankRepository bankRepository) {
        this.branchRepository = branchRepository;
        this.bankRepository = bankRepository;
    }

    @Override
    public BranchDTO save(BranchDTO branchDTO) {
        try {
            Branch branch;
            if (branchDTO.getId() == null) {
                branch = new Branch();
            } else {
                branch = this.branchRepository.getById(branchDTO.getId());
            }
            Bank bank = bankRepository.findByCode(branchDTO.getCode());
            branch.setBank(bank);
            branch.setCode(branchDTO.getCode());
            branch = branchRepository.save(branch);
            branchDTO.setId(branch.getId());
            return branchDTO;
        } catch (ConstraintViolationException | DataIntegrityViolationException ex) {
            throw new DuplicateFoundException("Is not possible to create two branch with the same code at the same bank");
        }
    }

    @Override
    public BranchDTO findById(Integer id) {
        return new BranchDTO(branchRepository.getById(id));
    }

    @Override
    public List<BranchDTO> findAll() {
        List<Branch> branches = branchRepository.findAll();
        return branches.stream().map(BranchDTO::new).collect(Collectors.toList());
    }

    @Override
    public String destroy(Integer id) {
        branchRepository.deleteById(id);
        return "Branch deleted";
    }
}
