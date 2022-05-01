package br.com.letscode.dbbanco.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class SaqueRequestDTO {
    @NotNull
    @Positive
    private int numeroConta;

    @NotNull
    @Pattern(regexp="^\\d{6}$",message = "Senha deverá ter 6 dígitos")
    private int senha;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=6, fraction=2)
    private BigDecimal valor;

}
