package br.com.letscode.dbbanco.entities.conta;

import br.com.letscode.dbbanco.entities.cliente.Cliente;

public class Investimento extends ContaDefault {
    public Investimento(Cliente cliente, TipoConta tipoConta, String agencia, String senha) {
        super(cliente, tipoConta, agencia, senha);
    }

    // Herdar de ContaDefault
    // Enum Tipo Conta = Investimento

}
