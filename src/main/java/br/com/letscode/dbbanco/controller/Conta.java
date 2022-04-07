package br.com.letscode.dbbanco.controller;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.conta.Agencia;
import br.com.letscode.dbbanco.entities.conta.TipoConta;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ToString
@NoArgsConstructor
@Getter
@Setter

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroConta;

    @OneToOne
    private Cliente cliente;

    private BigDecimal saldo = BigDecimal.valueOf(0);

    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    private Integer agencia;

    private String senha;

    private LocalDateTime dataAbertura = LocalDateTime.now();

    public Conta(Cliente cliente, TipoConta tipoConta, Integer agencia, String senha) {
        this.cliente = cliente;
        this.tipoConta = tipoConta;
        this.agencia = agencia;
        this.senha = senha;
    }
}
