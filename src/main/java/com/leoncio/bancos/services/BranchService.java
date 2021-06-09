package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.BranchDTO;

import java.util.List;


public interface BranchService {

    BranchDTO save(BranchDTO branchDTO);

    BranchDTO findById(Integer id);

    List<BranchDTO> findAll();

    String destroy(Integer id);

}
