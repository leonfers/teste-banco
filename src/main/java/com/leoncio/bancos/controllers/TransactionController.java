package com.leoncio.bancos.controllers;

import com.leoncio.bancos.config.Const;
import com.leoncio.bancos.dto.DepositDTO;
import com.leoncio.bancos.dto.Response;
import com.leoncio.bancos.dto.TransferDTO;
import com.leoncio.bancos.dto.WithdrawalDTO;
import com.leoncio.bancos.form.DepositForm;
import com.leoncio.bancos.form.TransferForm;
import com.leoncio.bancos.form.WithdrawalForm;
import com.leoncio.bancos.services.TransactionService;
import org.hibernate.StaleObjectStateException;
import org.hibernate.exception.LockAcquisitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("transactions")
@Secured({Const.ROLE_CLIENT, Const.ROLE_ADMIN})
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(path = "/withdrawal", produces = "application/json")
    public Response withdrawal(@RequestBody @Valid WithdrawalForm withdrawalForm) {
        while (true) {
            try {
                return new Response(transactionService.doWithdrawal(new WithdrawalDTO(withdrawalForm)));
            } catch (OptimisticLockingFailureException | StaleObjectStateException | LockAcquisitionException | CannotAcquireLockException ex) {
                //retry
            }
        }
    }

    @PostMapping(path = "/deposit", produces = "application/json")
    public Response deposit(@RequestBody @Valid DepositForm depositForm) {
        while (true) {
            try {
                return new Response(transactionService.doDeposit(new DepositDTO(depositForm)));
            } catch (OptimisticLockingFailureException | StaleObjectStateException | LockAcquisitionException |
                    CannotAcquireLockException ex) {
                //retry
            }
        }
    }

    @PostMapping(path = "/transfer", produces = "application/json")
    public Response transfer(@RequestBody @Valid TransferForm transferForm) {
        while (true) {
            try {
                return new Response(transactionService.doTransfer(new TransferDTO(transferForm)));
            } catch (OptimisticLockingFailureException | StaleObjectStateException | LockAcquisitionException | CannotAcquireLockException ex) {
                //retry
            }
        }

    }
}
