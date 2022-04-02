package br.com.letscode.dbbanco.entities.conta;

import br.com.letscode.dbbanco.entities.cliente.Cliente;

public class Corrente extends ContaDefault {
    public Corrente(Cliente cliente, TipoConta tipoConta, String agencia, String senha) {
        super(cliente, tipoConta, agencia, senha);
    }

    // Herdar de ContaDefault
    // Enum Tipo Conta = Corrente

}
