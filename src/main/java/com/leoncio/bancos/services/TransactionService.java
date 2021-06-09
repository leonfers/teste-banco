package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TransactionService {

    WithdrawalDTO doWithdrawal(WithdrawalDTO withdrawalDTO);

    DepositDTO doDeposit(DepositDTO depositDTO);

    TransferDTO doTransfer(TransferDTO transferDTO);

}
