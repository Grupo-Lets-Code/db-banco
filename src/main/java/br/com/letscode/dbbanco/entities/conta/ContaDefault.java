package br.com.letscode.dbbanco.entities.conta;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContaDefault {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Cliente cliente;

    private BigDecimal saldo = BigDecimal.valueOf(0);
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
