package com.leoncio.bancos.controllers;

import com.leoncio.bancos.config.Const;
import com.leoncio.bancos.dto.AccountDTO;
import com.leoncio.bancos.dto.Response;
import com.leoncio.bancos.form.AccountForm;
import com.leoncio.bancos.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping("accounts")
@Secured({Const.ROLE_CLIENT})
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
        return new Response(accountService.findById(id));
    }

    @GetMapping(path = "/bank-statement/{id}", produces = "application/json")
    public Response bankStatement(@PathVariable int id,
                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return new Response(accountService.getBankStatementByAccountId(id, startDate, endDate));
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public Response edit(@PathVariable int id, @RequestBody @Valid AccountForm accountForm) {
        AccountDTO accountDTO = new AccountDTO(accountForm);
        accountDTO.setId(id);
        return new Response(accountService.save(accountDTO));
    }

    @PostMapping(produces = "application/json")
    public Response create(@RequestBody @Valid AccountForm accountForm) {
        return new Response(accountService.save(new AccountDTO(accountForm)));
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public Response destroy(@PathVariable int id) {
        return new Response(accountService.destroy(id));
    }
}
