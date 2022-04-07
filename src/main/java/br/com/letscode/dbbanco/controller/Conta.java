package br.com.letscode.dbbanco.controller;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.conta.Agencia;
import br.com.letscode.dbbanco.entities.conta.TipoConta;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@ToString
@NoArgsConstructor
@Getter
@Setter



@Entity
@Table(name = "Contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    protected int conta_id;

    @OneToOne
    @JoinColumn(name = "cliente_id",nullable = false)
    protected Cliente cliente_id;

    @OneToOne
    @JoinColumn(name = "agencia_numeroAgencia", nullable = false)
    protected Agencia agencia;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    protected int numero;

    @Column(nullable = false)
    protected String senha;

    @Column(nullable = false)
    protected String data_abertura;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected TipoConta tipoConta;

    @Column(nullable = false)
    protected BigDecimal saldo = BigDecimal.valueOf(0);

    public Conta(Cliente cliente_id, Agencia agencia, int numero, String senha, String data_abertura, TipoConta tipoConta, BigDecimal saldo) {
        this.cliente_id = cliente_id;
        this.agencia = agencia;
        this.numero = numero;
        this.senha = senha;
        this.data_abertura = data_abertura;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
    }

}
