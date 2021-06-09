package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.DepositDTO;
import com.leoncio.bancos.dto.TransactionDTO;
import com.leoncio.bancos.dto.TransferDTO;
import com.leoncio.bancos.dto.WithdrawalDTO;
import com.leoncio.bancos.models.Account;
import com.leoncio.bancos.models.Deposit;
import com.leoncio.bancos.models.Transfer;
import com.leoncio.bancos.models.Withdrawl;
import com.leoncio.bancos.repositories.AccountRepository;
import com.leoncio.bancos.repositories.TransactionRepository;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

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
    public WithdrawalDTO doWithdrawal(WithdrawalDTO withdrawalDTO) {
        try{
            Account origin = accountRepository.findByCode(withdrawalDTO.getOriginAccountCode());
            Withdrawl withdrawl = new Withdrawl();
            withdrawl.setAmount(withdrawalDTO.getAmount());
            withdrawl.setDate(LocalDateTime.now());
            withdrawl.setOrigin(origin);
            transactionRepository.save(withdrawl);
            origin.setBalance(origin.getBalance().subtract(withdrawl.getAmount()));
            accountRepository.save(origin);
            withdrawalDTO.setId(withdrawl.getId());
            withdrawalDTO.setDate(withdrawl.getDate());
            return withdrawalDTO;
        }catch (OptimisticLockingFailureException ex){
            // retry transaction
            return doWithdrawal(withdrawalDTO);
        }
    }

    @Override
    @Transactional
    public DepositDTO doDeposit(DepositDTO depositDTO) {
        try{
            Account destiny = accountRepository.findByCode(depositDTO.getDestinyAccountCode());
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
        }catch (OptimisticLockingFailureException ex){
            // retry transaction
            return doDeposit(depositDTO);
        }
    }

    @Override
    public TransferDTO doTransfer(TransferDTO transferDTO) {
        try{
            Account origin = accountRepository.findByCode(transferDTO.getOriginAccountCode());
            Account destiny = accountRepository.findByCode(transferDTO.getDestinyAccountCode());
            Transfer transfer = new Transfer();
            transfer.setAmount(transferDTO.getAmount());
            transfer.setDate(LocalDateTime.now());
            transfer.setDestiny(destiny);
            transactionRepository.save(transfer);
            origin.setBalance(destiny.getBalance().subtract(transfer.getAmount()));
            destiny.setBalance(destiny.getBalance().add(transfer.getAmount()));
            accountRepository.save(destiny);
            transferDTO.setId(transfer.getId());
            transferDTO.setDate(transfer.getDate());
            return transferDTO;
        }catch (OptimisticLockingFailureException ex){
            // retry transaction
            return doTransfer(transferDTO);
        }
    }

    @Override
    public void destroy() {

    }
}
