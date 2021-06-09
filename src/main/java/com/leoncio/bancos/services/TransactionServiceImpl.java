package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.DepositDTO;
import com.leoncio.bancos.dto.TransactionDTO;
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
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionDTO save(TransactionDTO customerDTO) {
        return null;
    }

    @Override
    public TransactionDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<TransactionDTO> findAll() {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public WithdrawalDTO doWithdrawal(WithdrawalDTO withdrawalDTO) {
            Account origin = accountRepository.findByUserId(withdrawalDTO.getOriginAccountId());
            if (origin == null) {
                throw new ItemNotFoundException("Could not find account with " + withdrawalDTO.getOriginAccountId() + " account code");
            }
            if (origin.getBalance().subtract(withdrawalDTO.getAmount()).compareTo(BigDecimal.ZERO) < 0) {
                throw new ItemNotFoundException("Insufficient funds to complete withdrawal (" + origin.getBalance() + ")");
            }

            Withdrawal withdrawal = new Withdrawal();
            withdrawal.setAmount(withdrawalDTO.getAmount());
            withdrawal.setDate(LocalDateTime.now());
            withdrawal.setOrigin(origin);
            transactionRepository.save(withdrawal);
            origin.setBalance(origin.getBalance().subtract(withdrawal.getAmount()));
            accountRepository.save(origin);
            withdrawalDTO.setId(withdrawal.getId());
            withdrawalDTO.setDate(withdrawal.getDate());
            return withdrawalDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DepositDTO doDeposit(DepositDTO depositDTO) {
            Account destiny = accountRepository.findByUserId(depositDTO.getDestinyAccountId());
            if (destiny == null) {
                throw new ItemNotFoundException("Could not find account with " + depositDTO.getDestinyAccountId() + " account code");
            }
            Deposit deposit = new Deposit();
            deposit.setAmount(depositDTO.getAmount());
            deposit.setDate(LocalDateTime.now());
            deposit.setDestiny(destiny);
            transactionRepository.save(deposit);
            destiny.setBalance(destiny.getBalance().add(deposit.getAmount()));
            accountRepository.save(destiny);
            depositDTO.setId(deposit.getId());
            depositDTO.setDate(deposit.getDate());
            return depositDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TransferDTO doTransfer(TransferDTO transferDTO) {
        Account origin = accountRepository.findByUserId(transferDTO.getOriginAccountId());
        Account destiny = accountRepository.findByUserId(transferDTO.getDestinyAccountId());
        if (origin == null) {
            throw new ItemNotFoundException("Could not find account with id " + transferDTO.getOriginAccountId());
        }
        if (destiny == null) {
            throw new ItemNotFoundException("Could not find account with id " + transferDTO.getDestinyAccountId());
        }
        if (origin.getBalance().subtract(transferDTO.getAmount()).compareTo(BigDecimal.ZERO) < 0) {
            throw new ItemNotFoundException("Insufficient funds to complete transfer (" + origin.getBalance() + ")");
        }
        Transfer transfer = new Transfer();
        transfer.setAmount(transferDTO.getAmount());
        transfer.setDate(LocalDateTime.now());
        transfer.setOrigin(origin);
        transfer.setDestiny(destiny);
        transactionRepository.save(transfer);
        origin.setBalance(origin.getBalance().subtract(transfer.getAmount()));
        destiny.setBalance(destiny.getBalance().add(transfer.getAmount()));
        accountRepository.save(origin);
        accountRepository.save(destiny);
        transferDTO.setId(transfer.getId());
        transferDTO.setDate(transfer.getDate());
        return transferDTO;
    }

    @Override
    public void destroy() {

    }
}
