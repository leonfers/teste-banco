package com.leoncio.bancos.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leoncio.bancos.dto.BranchDTO;
import com.leoncio.bancos.dto.DepositDTO;
import com.leoncio.bancos.dto.TransferDTO;
import com.leoncio.bancos.dto.WithdrawalDTO;
import com.leoncio.bancos.form.BranchForm;
import com.leoncio.bancos.form.DepositForm;
import com.leoncio.bancos.form.TransferForm;
import com.leoncio.bancos.form.WithdrawalForm;
import com.leoncio.bancos.services.BranchService;
import com.leoncio.bancos.services.TransactionService;
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

import java.math.BigDecimal;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles({ "dev", "test"})
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
class TransactionControllerTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    @Test
    void it_should_return_deposit_created() throws Exception {
        DepositForm depositForm = new DepositForm();
        depositForm.setAmount(BigDecimal.TEN);
        depositForm.setDestinyAccountId(1);
        when(transactionService.doDeposit(any(DepositDTO.class))).thenReturn(new DepositDTO(depositForm));
        mockMvc.perform(MockMvcRequestBuilders.post("/transactions/deposit")
                .content(mapper.writeValueAsString(depositForm))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.amount").value(depositForm.getAmount()));
    }

    @Test
    void it_should_return_deposit_validation_error() throws Exception {
        DepositForm depositForm = new DepositForm();
        depositForm.setDestinyAccountId(1);
        mockMvc.perform(MockMvcRequestBuilders.post("/transactions/deposit")
                .content(mapper.writeValueAsString(depositForm))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void it_should_return_withdrawal_created() throws Exception {
        WithdrawalForm withdrawalForm = new WithdrawalForm();
        withdrawalForm.setAmount(BigDecimal.TEN);
        withdrawalForm.setOriginAccountId(1);
        when(transactionService.doWithdrawal(any(WithdrawalDTO.class))).thenReturn(new WithdrawalDTO(withdrawalForm));
        mockMvc.perform(MockMvcRequestBuilders.post("/transactions/withdrawal")
                .content(mapper.writeValueAsString(withdrawalForm))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.amount").value(withdrawalForm.getAmount()));
    }

    @Test
    void it_should_return_withdrawal_validation_error() throws Exception {
        WithdrawalForm withdrawalForm = new WithdrawalForm();
        withdrawalForm.setOriginAccountId(1);
        when(transactionService.doWithdrawal(any(WithdrawalDTO.class))).thenReturn(new WithdrawalDTO(withdrawalForm));
        mockMvc.perform(MockMvcRequestBuilders.post("/transactions/withdrawal")
                .content(mapper.writeValueAsString(withdrawalForm))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void it_should_return_transfer_created() throws Exception {
        TransferForm transferForm = new TransferForm();
        transferForm.setAmount(BigDecimal.TEN);
        transferForm.setOriginAccountId(1);
        transferForm.setDestinyAccountId(2);
        when(transactionService.doTransfer(any(TransferDTO.class))).thenReturn(new TransferDTO(transferForm));
        mockMvc.perform(MockMvcRequestBuilders.post("/transactions/transfer")
                .content(mapper.writeValueAsString(transferForm))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.amount").value(transferForm.getAmount()));
    }

    @Test
    void it_should_return_transfer_validation_error() throws Exception {
        TransferForm transferForm = new TransferForm();
        transferForm.setAmount(BigDecimal.TEN);
        transferForm.setDestinyAccountId(2);
        when(transactionService.doTransfer(any(TransferDTO.class))).thenReturn(new TransferDTO(transferForm));
        mockMvc.perform(MockMvcRequestBuilders.post("/transactions/transfer")
                .content(mapper.writeValueAsString(transferForm))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

}