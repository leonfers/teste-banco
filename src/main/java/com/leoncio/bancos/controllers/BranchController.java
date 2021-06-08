package com.leoncio.bancos.controllers;

import com.leoncio.bancos.dto.BranchDTO;
import com.leoncio.bancos.dto.Response;
import com.leoncio.bancos.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
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
        throw new UnsupportedOperationException();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Response show(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public Response edit(@PathVariable int id, @RequestBody BranchDTO branchDTO) {
        throw new UnsupportedOperationException();
    }

    @PostMapping(produces = "application/json")
    public Response create(@RequestBody BranchDTO branchDTO) {
        throw new UnsupportedOperationException();
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public Response destroy(@PathVariable int id) {
        throw new UnsupportedOperationException();
    }
}
