package com.leoncio.bancos.dto;

import com.leoncio.bancos.form.BranchForm;
import com.leoncio.bancos.models.Branch;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class BranchDTO {

    private Integer id;
    private String code;
    private String bankCode;
    private String bankName;

    public BranchDTO(BranchForm branchForm) {
        this.code = branchForm.getCode();
        this.bankCode = branchForm.getBankCode();
    }

    public BranchDTO(Branch branch) {
        this.id = branch.getId();
        this.code = branch.getCode();
        this.bankCode = branch.getBank().getCode();
        this.bankName = branch.getBank().getName();
    }
}
