package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.BranchDTO;
import com.leoncio.bancos.repositories.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService{

    private final BranchRepository branchRepository;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public BranchDTO save(BranchDTO branchDTO) {
        return null;
    }

    @Override
    public BranchDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<BranchDTO> findAll() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
