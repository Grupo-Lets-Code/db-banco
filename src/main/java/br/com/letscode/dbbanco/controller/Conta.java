package br.com.letscode.dbbanco.controller;

import br.com.letscode.dbbanco.entities.conta.TipoConta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@ToString
@NoArgsConstructor
@Getter
@Setter

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int conta_id;
    public int cliente_id;
    public int agencia_id;
    public int numero;
    public char senha;
    public Date data_abertura;

    @Enumerated(EnumType.STRING)
    private TipoConta tipoconta;

    public BigDecimal saldo;


}
