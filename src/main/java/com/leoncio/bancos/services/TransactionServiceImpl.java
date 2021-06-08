package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.DepositDTO;
import com.leoncio.bancos.dto.TransactionDTO;
import com.leoncio.bancos.dto.TransferDTO;
import com.leoncio.bancos.dto.WithdrawalDTO;
import com.leoncio.bancos.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
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
    public WithdrawalDTO doWithdrawal() {
        return null;
    }

    @Override
    public DepositDTO doDeposit() {
        return null;
    }

    @Override
    public TransferDTO doTransfer() {
        return null;
    }

    @Override
    public TransactionDTO doTranscation() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
