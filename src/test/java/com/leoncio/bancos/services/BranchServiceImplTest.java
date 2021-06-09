package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.BranchDTO;
import com.leoncio.bancos.form.BranchForm;
import com.leoncio.bancos.models.Bank;
import com.leoncio.bancos.models.Branch;
import com.leoncio.bancos.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@ActiveProfiles("dev")
class BranchServiceImplTest {

    @Mock
    BankRepository bankRepository;
    @Mock
    BranchRepository branchRepository;

    @InjectMocks
    BranchServiceImpl branchService;

    Bank bank;
    Branch branch;

    @BeforeEach
    public void setUp(){
        bank = new Bank();
        bank.setId(1);
        bank.setName("Nubank");
        bank.setCode("0001");

        branch = new Branch();
        branch.setBank(bank);
        branch.setCode("1");
        branch.setId(1);
    }

    @Test
    public void when_save_branch_it_should_return_branch_dto(){
        BranchDTO branchDTO = new BranchDTO(new BranchForm("1", "0001"));
        when(bankRepository.findByCode(ArgumentMatchers.any(String.class))).thenReturn(bank);
        when(branchRepository.save(ArgumentMatchers.any(Branch.class))).thenReturn(branch);
        BranchDTO created = branchService.save(branchDTO);
        assertThat(created.getId()).isSameAs(branch.getId());
    }

    @Test
    public void when_find_by_id_branch_it_should_return_branch_dto(){
        when(branchRepository.getById(ArgumentMatchers.any(Integer.class))).thenReturn(branch);
        BranchDTO branchDTO = branchService.findById(1);
        assertThat(branchDTO.getId()).isSameAs(branch.getId());
    }


    @Test
    public void when_find_all_it_should_return_list_of_branch_dto(){
        when(branchRepository.findAll()).thenReturn(Collections.singletonList(branch));
        List<BranchDTO> branches = branchService.findAll();
        assertThat(branches.get(0).getId()).isSameAs(branch.getId());
    }

    @Test
    public void when_destroy_it_should_return_branch_deleted(){
        String result = branchService.destroy(1);
        assertThat(result).isSameAs("Branch deleted");
    }
}