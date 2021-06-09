package com.leoncio.bancos.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leoncio.bancos.dto.BankDTO;
import com.leoncio.bancos.dto.BranchDTO;
import com.leoncio.bancos.form.BankForm;
import com.leoncio.bancos.form.BranchForm;
import com.leoncio.bancos.services.BankService;
import com.leoncio.bancos.services.BranchService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles({ "dev", "test"})
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
class BranchControllerTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BranchService branchService;

    @Test
    void it_should_return_branch_created() throws Exception {
        BranchForm branchForm = new BranchForm();
        branchForm.setCode("1");
        branchForm.setBankCode("1");
        when(branchService.save(any(BranchDTO.class))).thenReturn(new BranchDTO(branchForm));
        mockMvc.perform(MockMvcRequestBuilders.post("/branches")
                .content(mapper.writeValueAsString(branchForm))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.code").value(branchForm.getCode()));
    }

    @Test
    void it_should_return_validation_error() throws Exception {
        BranchForm branch = new BranchForm();
        branch.setCode("1");
        when(branchService.save(any(BranchDTO.class))).thenReturn(new BranchDTO(branch));
        mockMvc.perform(post("/branchs")
                .content(mapper.writeValueAsString(branch))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void it_should_return_one_branches_dto() throws Exception {
        BranchDTO branch = new BranchDTO();
        branch.setId(1);
        branch.setCode("1");
        branch.setBankCode("1");
        when(branchService.findById(any(Integer.class))).thenReturn(branch);
        mockMvc.perform(get("/branches/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.code").value(branch.getCode()));
    }

    @Test
    void it_should_return_list_of_branches_dto() throws Exception {
        List<BranchDTO> branchs = new ArrayList<>();
        BranchDTO branch = new BranchDTO();
        branch.setId(1);
        branch.setCode("1");
        branch.setBankCode("1");
        branchs.add(branch);

        when(branchService.findAll()).thenReturn(branchs);
        mockMvc.perform(get("/branches")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].code").value(branch.getCode()));
    }


    @Test
    void it_should_return_one_edited_bank_dto() throws Exception {
        BranchDTO branch = new BranchDTO();
        branch.setCode("1");
        branch.setBankCode("1");
        when(branchService.save(any(BranchDTO.class))).thenReturn(branch);
        mockMvc.perform(put("/branches/1")
                .content(mapper.writeValueAsString(branch))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.code").value(branch.getCode()));
    }


    @Test
    void it_should_just_delete() throws Exception {
        mockMvc.perform(delete("/branches/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}