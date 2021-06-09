package com.leoncio.bancos.dto;

import com.leoncio.bancos.form.BranchForm;
import com.leoncio.bancos.models.Branch;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class BranchDTO  implements BaseDTO{

    private Integer id;
    private String code;
    private String bankCode;
    private String address;
    private List<AccountDTO> accounts;

    public BranchDTO(BranchForm branchForm) {
        this.code = branchForm.getCode();
        this.bankCode = branchForm.getBankCode();
        this.address = branchForm.getAddress();
    }

    public BranchDTO(Branch branch) {
        this.id = branch.getId();
        this.code = branch.getCode();
        this.bankCode = branch.getBank().getCode();
        this.address = branch.getAddress();
    }

    @Override
    public String toString() {
        return "BranchDTO{" +
                "code='" + code + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", address='" + address + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
