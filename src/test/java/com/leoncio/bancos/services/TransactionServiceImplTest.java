package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.BankDTO;
import com.leoncio.bancos.dto.DepositDTO;
import com.leoncio.bancos.dto.TransferDTO;
import com.leoncio.bancos.dto.WithdrawalDTO;
import com.leoncio.bancos.form.BankForm;
import com.leoncio.bancos.form.DepositForm;
import com.leoncio.bancos.form.TransferForm;
import com.leoncio.bancos.form.WithdrawalForm;
import com.leoncio.bancos.models.*;
import com.leoncio.bancos.repositories.AccountRepository;
import com.leoncio.bancos.repositories.TransactionRepository;
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

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@ActiveProfiles("dev")
class TransactionServiceImplTest {

    @Mock
    private AccountRepository accountRepository;
    @Mock
    private TransactionRepository transactionRepository;


    @InjectMocks
    private TransactionServiceImpl transactionService;

    Account destiny;
    Account origin;
    Transfer transfer;
    Deposit deposit;
    Withdrawal withdrawal;

    @BeforeEach
    public void setUp(){
        User user = new User();
        user.setId(1);

        Bank bank = new Bank();
        bank.setId(1);
        bank.setName("Nubank");
        bank.setCode("0001");

        Branch branch = new Branch();
        branch.setBank(bank);
        branch.setCode("1");
        branch.setId(1);

        Branch branch2 = new Branch();
        branch.setBank(bank);
        branch.setCode("2");
        branch.setId(2);

        destiny = new Account();
        destiny.setBranch(branch);
        destiny.setUser(user);
        destiny.setBalance(BigDecimal.TEN);

        origin = new Account();
        origin.setBranch(branch2);
        origin.setUser(user);
        origin.setBalance(BigDecimal.TEN);

        deposit = new Deposit();
        deposit.setDate(LocalDateTime.now());
        deposit.setAmount(BigDecimal.TEN);
        deposit.setDestiny(destiny);

        withdrawal = new Withdrawal();
        withdrawal.setDate(LocalDateTime.now());
        withdrawal.setAmount(BigDecimal.ONE);
        withdrawal.setOrigin(origin);

        transfer = new Transfer();
        transfer.setDate(LocalDateTime.now());
        transfer.setAmount(BigDecimal.ONE);
        transfer.setOrigin(origin);
        transfer.setDestiny(destiny);

    }

    @Test
    public void when_do_deposit_it_should_return_deposit_dto(){
        DepositDTO depositDTO = new DepositDTO(new DepositForm(1, BigDecimal.TEN));
        when(transactionRepository.save(ArgumentMatchers.any(Transaction.class))).thenReturn(deposit);
        when(accountRepository.findById(ArgumentMatchers.any(Integer.class))).thenReturn(java.util.Optional.ofNullable(destiny));
        DepositDTO created = transactionService.doDeposit(depositDTO);
        assertThat(created.getAmount()).isSameAs(deposit.getAmount());
    }

    @Test
    public void when_do_widrawal_it_should_return_widrawal_dto(){
        WithdrawalDTO withdrawalDTO = new WithdrawalDTO(new WithdrawalForm(1, BigDecimal.ONE));
        when(transactionRepository.save(ArgumentMatchers.any(Transaction.class))).thenReturn(withdrawal);
        when(accountRepository.findById(ArgumentMatchers.any(Integer.class))).thenReturn(java.util.Optional.ofNullable(origin));
        WithdrawalDTO created = transactionService.doWithdrawal(withdrawalDTO);
        assertThat(created.getAmount()).isSameAs(withdrawal.getAmount());
    }

    @Test
    public void when_do_transfer_it_should_return_transfer_dto(){
        TransferDTO transferDTO = new TransferDTO(new TransferForm(1,2, BigDecimal.ONE));
        when(transactionRepository.save(ArgumentMatchers.any(Transaction.class))).thenReturn(deposit);
        when(accountRepository.findById(ArgumentMatchers.eq(1))).thenReturn(java.util.Optional.ofNullable(origin));
        when(accountRepository.findById(ArgumentMatchers.eq(2))).thenReturn(java.util.Optional.ofNullable(destiny));
        TransferDTO created = transactionService.doTransfer(transferDTO);
        assertThat(created.getAmount()).isSameAs(transfer.getAmount());
    }

}