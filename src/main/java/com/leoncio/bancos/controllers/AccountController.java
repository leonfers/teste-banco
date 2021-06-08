package com.leoncio.bancos.controllers;

import com.leoncio.bancos.dto.AccountDTO;
import com.leoncio.bancos.dto.ResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("accounts")
public class AccountController {
    @GetMapping(produces = "application/json")
    public ResponseDTO list() {
        throw new UnsupportedOperationException();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO show(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO edit(@PathVariable int id, @RequestBody AccountDTO accountDTO) {
        throw new UnsupportedOperationException();
    }

    @PostMapping(produces = "application/json")
    public ResponseDTO create(@RequestBody AccountDTO accountDTO) {
        throw new UnsupportedOperationException();
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO destroy(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }
}
