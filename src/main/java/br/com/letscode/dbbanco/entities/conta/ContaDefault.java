package br.com.letscode.dbbanco.entities.conta;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ContaDefault {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne(optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    private BigDecimal saldo = BigDecimal.valueOf(0);

    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    private String agencia;
    private long numeroConta;
    private String senha;
    private LocalDateTime dataAbertura;

    public ContaDefault(Cliente cliente, TipoConta tipoConta, String agencia, String senha) {
        this.cliente = cliente;
        this.tipoConta = tipoConta;
        this.agencia = agencia;
        this.senha = senha;
    }
}
