package com.leoncio.bancos.controllers;

import com.leoncio.bancos.dto.*;
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


    @PostMapping(path = "/withdrawal", produces = "application/json")
    public Response withdrawal(@RequestBody WithdrawalDTO withdrawalDTO) {
        throw new UnsupportedOperationException();
    }

    @PostMapping(path = "/deposit", produces = "application/json")
    public Response deposit(@RequestBody DepositDTO depositDTO) {
        throw new UnsupportedOperationException();
    }

    @PostMapping(path = "/transfer", produces = "application/json")
    public Response transfer(@RequestBody TransferDTO transferDTO) {
        throw new UnsupportedOperationException();
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public Response destroy(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }
}
