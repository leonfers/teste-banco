package com.leoncio.bancos.controllers;

import com.leoncio.bancos.dto.BankDTO;
import com.leoncio.bancos.dto.Response;
import com.leoncio.bancos.form.BankForm;
import com.leoncio.bancos.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("banks")
public class BankController {

    private final BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping(produces = "application/json")
    public Response list() {
        return new Response(bankService.findAll());
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Response show(@PathVariable int id) {
        return new Response(bankService.findById(id));
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public Response edit(@PathVariable int id, @Valid @RequestBody BankForm bankForm) {
        BankDTO bankDTO = new BankDTO(bankForm);
        bankDTO.setId(id);
        return new Response(bankService.save(bankDTO));
    }

    @PostMapping(produces = "application/json")
    public Response create(@Valid @RequestBody BankForm bankForm) {
        return new Response(bankService.save(new BankDTO(bankForm)));
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public Response destroy(@PathVariable int id) {
        bankService.destroy(id);
        return new Response("Banco deletado!");
    }
}
