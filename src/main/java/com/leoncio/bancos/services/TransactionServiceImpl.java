package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.DepositDTO;
import com.leoncio.bancos.dto.TransferDTO;
import com.leoncio.bancos.dto.WithdrawalDTO;
import com.leoncio.bancos.errorhandling.exceptions.ItemNotFoundException;
import com.leoncio.bancos.models.Account;
import com.leoncio.bancos.models.Deposit;
import com.leoncio.bancos.models.Transfer;
import com.leoncio.bancos.models.Withdrawal;
import com.leoncio.bancos.repositories.AccountRepository;
import com.leoncio.bancos.repositories.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public WithdrawalDTO doWithdrawal(WithdrawalDTO withdrawalDTO) {
        Optional<Account> origin = accountRepository.findById(withdrawalDTO.getOriginAccountId());
        if (origin.isEmpty()) {
            throw new ItemNotFoundException("Could not find account with " + withdrawalDTO.getOriginAccountId() + " account code");
        }
        if (origin.get().getBalance().subtract(withdrawalDTO.getAmount()).compareTo(BigDecimal.ZERO) < 0) {
            throw new ItemNotFoundException("Insufficient funds to complete withdrawal (" + origin.get().getBalance() + ")");
        }

        Withdrawal withdrawal = new Withdrawal();
        withdrawal.setAmount(withdrawalDTO.getAmount());
        withdrawal.setDate(LocalDateTime.now());
        withdrawal.setOrigin(origin.get());
        transactionRepository.save(withdrawal);
        origin.get().setBalance(origin.get().getBalance().subtract(withdrawal.getAmount()));
        accountRepository.save(origin.get());
        withdrawalDTO.setId(withdrawal.getId());
        withdrawalDTO.setDate(withdrawal.getDate());
        return withdrawalDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DepositDTO doDeposit(DepositDTO depositDTO) {
        Optional<Account> destiny = accountRepository.findById(depositDTO.getDestinyAccountId());
        if (destiny.isEmpty()) {
            throw new ItemNotFoundException("Could not find account with " + depositDTO.getDestinyAccountId() + " account code");
        }
        Deposit deposit = new Deposit();
        deposit.setAmount(depositDTO.getAmount());
        deposit.setDate(LocalDateTime.now());
        deposit.setDestiny(destiny.get());
        transactionRepository.save(deposit);
        destiny.get().setBalance(destiny.get().getBalance().add(deposit.getAmount()));
        accountRepository.save(destiny.get());
        depositDTO.setId(deposit.getId());
        depositDTO.setDate(deposit.getDate());
        return depositDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TransferDTO doTransfer(TransferDTO transferDTO) {
        Optional<Account> origin = accountRepository.findById(transferDTO.getOriginAccountId());
        Optional<Account> destiny = accountRepository.findById(transferDTO.getDestinyAccountId());
        if (origin.isEmpty()) {
            throw new ItemNotFoundException("Could not find account with id " + transferDTO.getOriginAccountId());
        }
        if (destiny.isEmpty()) {
            throw new ItemNotFoundException("Could not find account with id " + transferDTO.getDestinyAccountId());
        }
        if (origin.get().getBalance().subtract(transferDTO.getAmount()).compareTo(BigDecimal.ZERO) < 0) {
            throw new ItemNotFoundException("Insufficient funds to complete transfer (" + origin.get().getBalance() + ")");
        }
        Transfer transfer = new Transfer();
        transfer.setAmount(transferDTO.getAmount());
        transfer.setDate(LocalDateTime.now());
        transfer.setOrigin(origin.get());
        transfer.setDestiny(destiny.get());
        transactionRepository.save(transfer);
        origin.get().setBalance(origin.get().getBalance().subtract(transfer.getAmount()));
        destiny.get().setBalance(destiny.get().getBalance().add(transfer.getAmount()));
        accountRepository.save(origin.get());
        accountRepository.save(destiny.get());
        transferDTO.setId(transfer.getId());
        transferDTO.setDate(transfer.getDate());
        return transferDTO;
    }
}
