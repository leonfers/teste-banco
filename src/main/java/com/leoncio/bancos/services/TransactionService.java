package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {

    public TransactionDTO save(TransactionDTO customerDTO);

    public TransactionDTO findById(Integer id);

    public List<TransactionDTO> findAll();

    public WithdrawalDTO doWithdrawal();

    public DepositDTO doDeposit();

    public TransferDTO doTransfer();

    public TransactionDTO doTranscation();

    public void destroy();

}
