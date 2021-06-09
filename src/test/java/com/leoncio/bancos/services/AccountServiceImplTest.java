package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.AccountDTO;
import com.leoncio.bancos.form.AccountForm;
import com.leoncio.bancos.models.Account;
import com.leoncio.bancos.models.Bank;
import com.leoncio.bancos.models.Branch;
import com.leoncio.bancos.models.User;
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
class AccountServiceImplTest {

    @Mock
    BankRepository bankRepository;
    @Mock
    BranchRepository branchRepository;
    @Mock
    AccountRepository accountRepository;
    @Mock
    TransactionRepository transactionRepository;
    @Mock
    UserRepository userRepository;

    @InjectMocks
    AccountServiceImpl accountService;

    Bank bank;
    Branch branch;
    Account account;
    User user;

    @BeforeEach
    public void setUp(){
        user = new User();
        user.setId(1);

        bank = new Bank();
        bank.setId(1);
        bank.setName("Nubank");
        bank.setCode("0001");

        branch = new Branch();
        branch.setBank(bank);
        branch.setCode("1");
        branch.setId(1);

        account = new Account();
        account.setBranch(branch);
        account.setUser(user);
    }

    @Test
    public void when_save_account_it_should_return_account_dto(){
        AccountDTO accountDTO = new AccountDTO(new AccountForm(1, 1));
        when(accountRepository.save(ArgumentMatchers.any(Account.class))).thenReturn(account);
        when(userRepository.findById(ArgumentMatchers.any(Integer.class))).thenReturn(java.util.Optional.ofNullable(user));
        when(branchRepository.findById(ArgumentMatchers.any(Integer.class))).thenReturn(java.util.Optional.ofNullable(branch));
        AccountDTO created = accountService.save(accountDTO);
        assertThat(created.getUserId()).isSameAs(accountDTO.getUserId());
    }

    @Test
    public void when_find_by_id_account_it_should_return_account_dto(){
        when(accountRepository.getById(ArgumentMatchers.any(Integer.class))).thenReturn(account);
        AccountDTO accountDTO = accountService.findById(1);
        assertThat(accountDTO.getId()).isSameAs(account.getId());
    }


    @Test
    public void when_find_all_it_should_return_list_of_accounts_dto(){
        when(accountRepository.findAll()).thenReturn(Collections.singletonList(account));
        List<AccountDTO> accounts = accountService.findAll();
        assertThat(accounts.get(0).getId()).isSameAs(account.getId());
    }

    @Test
    public void when_destroy_it_should_return_account_deleted(){
        String result = accountService.destroy(1);
        assertThat(result).isSameAs("Account deleted");
    }

}