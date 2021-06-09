package com.leoncio.bancos.controllers;

import com.leoncio.bancos.dto.BranchDTO;
import com.leoncio.bancos.dto.Response;
import com.leoncio.bancos.form.BranchForm;
import com.leoncio.bancos.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("branches")
public class BranchController {

    private final BranchService branchService;

    @Autowired
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping(produces = "application/json")
    public Response list() {
        return new Response(branchService.findAll());
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Response show(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public Response edit(@PathVariable int id, @RequestBody BranchForm branchForm) {
        throw new UnsupportedOperationException();
    }

    @PostMapping(produces = "application/json")
    public Response create(@RequestBody @Validated BranchForm branchForm) {
        return new Response(branchService.save(new BranchDTO(branchForm)));
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public Response destroy(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }
}
