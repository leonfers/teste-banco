package com.leoncio.bancos.controllers;

import com.leoncio.bancos.config.Const;
import com.leoncio.bancos.dto.BranchDTO;
import com.leoncio.bancos.dto.Response;
import com.leoncio.bancos.form.BranchForm;
import com.leoncio.bancos.services.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("branches")
@Secured({Const.ROLE_CLIENT, Const.ROLE_ADMIN})
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
        return new Response(branchService.findById(id));
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public Response edit(@PathVariable int id, @RequestBody @Valid BranchForm branchForm) {
        BranchDTO branchDTO = new BranchDTO(branchForm);
        branchDTO.setId(id);
        return new Response(branchService.save(branchDTO));
    }

    @PostMapping(produces = "application/json")
    public Response create(@RequestBody @Valid BranchForm branchForm) {
        return new Response(branchService.save(new BranchDTO(branchForm)));
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public Response destroy(@PathVariable int id) {
        return new Response(branchService.destroy(id));
    }
}
