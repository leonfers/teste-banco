package com.leoncio.bancos.controllers;

import com.leoncio.bancos.dto.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transactions")
public class TransactionController {

    @GetMapping(produces = "application/json")
    public ResponseDTO list() {
        throw new UnsupportedOperationException();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO show(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }


    @PostMapping(path = "/withdrawal", produces = "application/json")
    public ResponseDTO withdrawal(@RequestBody WithdrawalDTO withdrawalDTO) {
        throw new UnsupportedOperationException();
    }

    @PostMapping(path = "/deposit", produces = "application/json")
    public ResponseDTO deposit(@RequestBody DepositDTO depositDTO) {
        throw new UnsupportedOperationException();
    }

    @PostMapping(path = "/transfer", produces = "application/json")
    public ResponseDTO transfer(@RequestBody TransferDTO transferDTO) {
        throw new UnsupportedOperationException();
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO destroy(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }
}
