package com.leoncio.bancos.dto;

import com.leoncio.bancos.form.CustomerForm;
import com.leoncio.bancos.models.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO implements BaseDTO {

    private Integer id;
    private String code;
    private String name;
    private String address;
    private List<AccountDTO> accounts;

    public CustomerDTO(CustomerForm customerForm) {
        this.code = customerForm.getCode();
        this.name = customerForm.getName();
        this.address = customerForm.getAddress();
    }

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.code = customer.getCode();
        this.name = customer.getName();
        this.address = customer.getAddress();
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
