package br.com.letscode.dbbanco.controller;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.conta.TipoConta;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

@Entity
@Table(name = "Contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    protected int conta_id;

    @OneToOne
    @Column(nullable = false)
    protected Cliente cliente_id;

    @Column(nullable = false)
    protected int agencia_id;

    @Column(nullable = false)
    protected int numero;

    @Column(nullable = false)
    protected char senha;

    @Column(nullable = false)
    protected Date data_abertura;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected TipoConta tipoconta;

    @Column(nullable = false)
    protected BigDecimal saldo;


}
