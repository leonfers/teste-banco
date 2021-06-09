package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.BranchDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BranchService {

    public BranchDTO save(BranchDTO branchDTO);

    public BranchDTO findById(Integer id);

    public List<BranchDTO> findAll();

    public void destroy();

}
