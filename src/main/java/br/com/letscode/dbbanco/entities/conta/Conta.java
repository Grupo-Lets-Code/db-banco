package br.com.letscode.dbbanco.entities.conta;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.cliente.TipoCliente;
import br.com.letscode.dbbanco.entities.conta.Agencia;
import br.com.letscode.dbbanco.entities.conta.TipoConta;
import lombok.*;

import javax.persistence.*;
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
    private Cliente cliente;

    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo = BigDecimal.valueOf(0);

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_Conta", nullable = false)
    private TipoConta tipoConta;

    @Column(name = "agencia",nullable = false)
    private Integer agencia;

    @Column(name = "senha", length = 6, nullable = false)
    private int senha; // SENHA 6 DIGITOS!

    @Column(name = "data_abertura", nullable = false)
    private LocalDateTime dataAbertura = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cliente", nullable = false)
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
        return "Lista de contas: \n" +
                "Numero da Conta: " + numeroConta +
                ", Nome: " + cliente.getNome() +
                ", Tipo da Conta: " + tipoConta +
                ", Numero da Agencia: " + agencia +
                ", tipo: " + tipoCliente + "\n";
    }
}
