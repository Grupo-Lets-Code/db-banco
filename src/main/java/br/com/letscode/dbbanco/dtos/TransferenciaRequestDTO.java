package br.com.letscode.dbbanco.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class TransferenciaRequestDTO {
    @NotNull(message = "Conta de origem inválida")
    @Positive
    private int contaOrigem;

    @NotNull(message = "Conta de destino inválida")
    @Positive
    private int contaDestino;

    @NotNull(message = "Senha inválida")
    private int senha;

    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=6, fraction=2)
    private BigDecimal valor;

}
