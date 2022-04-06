package br.com.letscode.dbbanco.entities.conta;

import br.com.letscode.dbbanco.entities.cliente.Cliente;

import javax.persistence.Entity;


public class Poupanca extends ContaDefault {
    public Poupanca(Cliente cliente, TipoConta tipoConta, String agencia, String senha) {
        super(cliente, tipoConta, agencia, senha);
    }

    // Herdar de ContaDefault
    // Enum Tipo Conta = Poupanca

}
