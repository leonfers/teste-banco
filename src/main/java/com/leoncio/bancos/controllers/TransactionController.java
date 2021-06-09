package com.leoncio.bancos.controllers;

import com.leoncio.bancos.dto.*;
import com.leoncio.bancos.form.DepositForm;
import com.leoncio.bancos.form.TransferForm;
import com.leoncio.bancos.form.WithdrawalForm;
import com.leoncio.bancos.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping(produces = "application/json")
    public Response list() {
        throw new UnsupportedOperationException();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Response show(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }


    @PostMapping(path = "/withdrawl", produces = "application/json")
    public Response withdrawal(@RequestBody WithdrawalForm withdrawalForm) {
        return new Response(transactionService.doWithdrawal(new WithdrawalDTO(withdrawalForm)));
    }

    @PostMapping(path = "/deposit", produces = "application/json")
    public Response deposit(@RequestBody DepositForm depositForm) {
       return new Response(transactionService.doDeposit(new DepositDTO(depositForm)));
    }

    @PostMapping(path = "/transfer", produces = "application/json")
    public Response transfer(@RequestBody TransferForm transferForm) {
        return new Response(transactionService.doTransfer(new TransferDTO(transferForm)));
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public Response destroy(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }
}
