package com.leoncio.bancos.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leoncio.bancos.dto.*;
import com.leoncio.bancos.form.AccountForm;
import com.leoncio.bancos.form.AccountForm;
import com.leoncio.bancos.services.AccountService;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
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
class AccountControllerTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    void it_should_return_account_created() throws Exception {
        AccountForm accountForm = new AccountForm();
        accountForm.setBranchId(1);
        accountForm.setUserId(1);
        when(accountService.save(any(AccountDTO.class))).thenReturn(new AccountDTO(accountForm));
        mockMvc.perform(MockMvcRequestBuilders.post("/accounts")
                .content(mapper.writeValueAsString(accountForm))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.branchId").value(accountForm.getBranchId()));
    }

    @Test
    void it_should_return_validation_error() throws Exception {
        AccountForm account = new AccountForm();
        when(accountService.save(any(AccountDTO.class))).thenReturn(new AccountDTO(account));
        mockMvc.perform(post("/accounts")
                .content(mapper.writeValueAsString(account))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void it_should_return_one_branch_dto() throws Exception {
        AccountDTO account = new AccountDTO();
        account.setId(1);
        account.setUserId(1);
        account.setBranchId(1);
        when(accountService.findById(any(Integer.class))).thenReturn(account);
        mockMvc.perform(get("/accounts/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.branchId").value(account.getBranchId()));
    }

    @Test
    void it_should_return_list_of_branch_dto() throws Exception {
        List<AccountDTO> accounts = new ArrayList<>();
        AccountDTO account = new AccountDTO();
        account.setId(1);
        account.setBranchId(1);
        account.setUserId(1);
        accounts.add(account);

        when(accountService.findAll()).thenReturn(accounts);
        mockMvc.perform(get("/accounts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].branchId").value(account.getBranchId()));
    }


    @Test
    void it_should_return_one_edited_branch_dto() throws Exception {
        AccountDTO account = new AccountDTO();
        account.setId(1);
        account.setBranchId(1);
        account.setUserId(1);
        account.setBankCode("1");
        when(accountService.save(any(AccountDTO.class))).thenReturn(account);
        mockMvc.perform(put("/accounts/1")
                .content(mapper.writeValueAsString(account))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.branchId").value(account.getBranchId()));
    }

    @Test
    void it_should_return_one_bank_statement_dto_with_total_9() throws Exception {
        BankStatementDTO bankStatementDTO = new BankStatementDTO();
        bankStatementDTO.setAccountId(1);
        bankStatementDTO.setBankName("Nubank");
        bankStatementDTO.setBranchCode("1");
        bankStatementDTO.setStartDate(LocalDate.of(2021,6,1));
        bankStatementDTO.setEndDate(LocalDate.of(2021,6,30));
        bankStatementDTO.setDate(LocalDateTime.now());
        bankStatementDTO.setCurrentBalance(BigDecimal.ONE);
        WithdrawalDTO withdrawalDTO = new WithdrawalDTO();
        withdrawalDTO.setDate(LocalDateTime.of(2021,6,3,12,0));
        withdrawalDTO.setAmount(BigDecimal.TEN);
        withdrawalDTO.setOriginAccountId(1);
        bankStatementDTO.setWithdrawals(Collections.singletonList(withdrawalDTO));

        DepositDTO depositDTO = new DepositDTO();
        depositDTO.setDate(LocalDateTime.of(2021,6,7,2,0));
        depositDTO.setAmount(BigDecimal.TEN.add(BigDecimal.TEN));
        depositDTO.setDestinyAccountId(1);
        bankStatementDTO.setDeposits(Collections.singletonList(depositDTO));

        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setDate(LocalDateTime.of(2021,6,10,5,0));
        transferDTO.setAmount(BigDecimal.ONE);
        transferDTO.setOriginAccountId(1);
        transferDTO.setDestinyAccountId(2);
        bankStatementDTO.setTransfers(Collections.singletonList(transferDTO));

        when(accountService.getBankStatementByAccountId(any(Integer.class),any(LocalDate.class),any(LocalDate.class) )).thenReturn(bankStatementDTO);
        mockMvc.perform(get("/accounts/bank-statement/1")
                .queryParam("startDate","2021-06-01")
                .queryParam("endDate","2021-06-30")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.total").value(9.0));
    }

    @Test
    void it_should_just_delete() throws Exception {
        mockMvc.perform(delete("/accounts/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}