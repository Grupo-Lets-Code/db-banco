package br.com.letscode.dbbanco.entities.conta;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.cliente.TipoCliente;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CONTA")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroConta;

    @OneToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @Valid
    private Cliente cliente;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo = BigDecimal.valueOf(0);

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "tipo_Conta", nullable = false)
    private TipoConta tipoConta;

    @NotNull(message = "Agência inválida")
    @Column(name = "agencia",nullable = false)
    private Integer agencia;


    @Column(name = "senha", length = 6, nullable = false)
    @NotNull(message = "Senha inválida")
    private int senha;

    @Column(name = "data_abertura", nullable = false)
    private LocalDateTime dataAbertura = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cliente", nullable = false)
    @NotNull(message = "Tipo de conta inválida")
    private TipoCliente tipoCliente;

    public Conta(Cliente cliente, TipoConta tipoConta, Integer agencia, int senha, TipoCliente tipoCliente) {
        this.cliente = cliente;
        this.tipoConta = tipoConta;
        this.agencia = agencia;
        this.senha = senha;
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return  "\nNumero da Conta: " + numeroConta +
                "\nNome: " + cliente.getNome() +
                "\nTipo da Conta: " + tipoConta +
                "\nNumero da Agencia: " + agencia +
                "\nTipo de Cliente: " + tipoCliente;
    }
}
