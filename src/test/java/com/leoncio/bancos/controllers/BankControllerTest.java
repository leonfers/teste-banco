package com.leoncio.bancos.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leoncio.bancos.dto.BankDTO;
import com.leoncio.bancos.form.BankForm;
import com.leoncio.bancos.services.BankService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles({ "dev", "test"})
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
class BankControllerTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BankService bankService;

    @Test
    void it_should_return_bank_created() throws Exception {
        BankForm bank = new BankForm();
        bank.setCode("1");
        bank.setName("teste");
        when(bankService.save(any(BankDTO.class))).thenReturn(new BankDTO(bank));
        mockMvc.perform(MockMvcRequestBuilders.post("/banks")
                .content(mapper.writeValueAsString(bank))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").value(bank.getName()));
    }

    @Test
    void it_should_return_validation_error() throws Exception {
        BankForm bank = new BankForm();
        bank.setCode("1");
        when(bankService.save(any(BankDTO.class))).thenReturn(new BankDTO(bank));
        mockMvc.perform(post("/banks")
                .content(mapper.writeValueAsString(bank))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void it_should_return_one_banks_dto() throws Exception {
        BankDTO bank = new BankDTO();
        bank.setId(1);
        bank.setCode("1");
        bank.setName("teste");
        when(bankService.findById(any(Integer.class))).thenReturn(bank);
        mockMvc.perform(get("/banks/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").value(bank.getName()));
    }

    @Test
    void it_should_return_list_of_banks_dto() throws Exception {
        List<BankDTO> banks = new ArrayList<>();
        BankDTO bank = new BankDTO();
        bank.setId(1);
        bank.setCode("1");
        bank.setName("teste");
        banks.add(bank);

        when(bankService.findAll()).thenReturn(banks);
        mockMvc.perform(get("/banks")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].name").value(bank.getName()));
    }


    @Test
    void it_should_return_one_edited_bank_dto() throws Exception {
        BankDTO bank = new BankDTO();
        bank.setCode("1");
        bank.setName("teste");
        when(bankService.save(any(BankDTO.class))).thenReturn(bank);
        mockMvc.perform(put("/banks/1")
                .content(mapper.writeValueAsString(bank))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").value(bank.getName()));
    }


    @Test
    void it_should_just_delete() throws Exception {
        mockMvc.perform(delete("/banks/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}