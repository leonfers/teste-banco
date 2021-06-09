package com.leoncio.bancos.controllers;

import com.leoncio.bancos.dto.AccountDTO;
import com.leoncio.bancos.dto.Response;
import com.leoncio.bancos.form.AccountForm;
import com.leoncio.bancos.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(produces = "application/json")
    public Response list() {
        return new Response(accountService.findAll());
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Response show(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public Response edit(@PathVariable int id, @RequestBody AccountForm accountForm) {
        throw new UnsupportedOperationException();
    }

    @PostMapping(produces = "application/json")
    public Response create(@RequestBody AccountForm accountForm) {
      return new Response(accountService.save(new AccountDTO(accountForm)));
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public Response destroy(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }
}
