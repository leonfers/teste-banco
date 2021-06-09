package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.BranchDTO;
import com.leoncio.bancos.models.Bank;
import com.leoncio.bancos.models.Branch;
import com.leoncio.bancos.repositories.BankRepository;
import com.leoncio.bancos.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService{

    private final BranchRepository branchRepository;
    private final BankRepository bankRepository;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, BankRepository bankRepository) {
        this.branchRepository = branchRepository;
        this.bankRepository = bankRepository;
    }

    @Override
    public BranchDTO save(BranchDTO branchDTO) {
        Bank bank = bankRepository.findByCode(branchDTO.getCode());
        Branch branch = new Branch();
        branch.setAddress(branchDTO.getAddress());
        branch.setBank(bank);
        branch.setCode(branchDTO.getCode());
        branchRepository.save(branch);
        branchDTO.setId(branch.getId());
        return branchDTO;
    }

    @Override
    public BranchDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<BranchDTO> findAll() {
        List<Branch> branches = branchRepository.findAll();
        return branches.stream().map(BranchDTO::new).collect(Collectors.toList());
    }

    @Override
    public void destroy() {

    }
}
