package com.leoncio.bancos.services;

import com.leoncio.bancos.dto.DepositDTO;
import com.leoncio.bancos.dto.TransferDTO;
import com.leoncio.bancos.dto.WithdrawalDTO;

public interface TransactionService {

    WithdrawalDTO doWithdrawal(WithdrawalDTO withdrawalDTO);

    DepositDTO doDeposit(DepositDTO depositDTO);

    TransferDTO doTransfer(TransferDTO transferDTO);

}
