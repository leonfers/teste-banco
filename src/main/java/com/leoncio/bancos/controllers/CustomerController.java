package com.leoncio.bancos.controllers;

import com.leoncio.bancos.config.Const;
import com.leoncio.bancos.dto.CustomerDTO;
import com.leoncio.bancos.dto.Response;
import com.leoncio.bancos.form.CustomerForm;
import com.leoncio.bancos.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("customers")
@Secured({Const.ROLE_CLIENT, Const.ROLE_ADMIN})
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(produces = "application/json")
    public Response list() {
        return new Response(customerService.findAll());
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Response show(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public Response edit(@PathVariable int id, @RequestBody @Valid CustomerForm customerForm) {
        throw new UnsupportedOperationException();
    }

    @PostMapping(produces = "application/json")
    public Response create(@RequestBody @Valid CustomerForm customerForm) {
        return new Response(customerService.save(new CustomerDTO(customerForm)));
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public Response destroy(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }
}
