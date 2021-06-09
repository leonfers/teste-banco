package com.leoncio.bancos.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class TransferForm {

    @NotBlank(message = "Origin account id is mandatory")
    private Integer originAccountId;

    @NotBlank(message = "Destiny account id is mandatory")
    private Integer destinyAccountId;

    @DecimalMin(value = "0.00", inclusive = false, message = "Amount need to be higher than zero")
    @Digits(integer=5, fraction=2, message = "Amount integral part can have at max 5 digits and the decimal part have at max 2 digits  ")
    private BigDecimal amount;
}
