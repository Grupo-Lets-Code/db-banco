package br.com.letscode.dbbanco.entities.conta;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@PrimaryKeyJoinColumn(name = "conta_id")
public class Corrente extends ContaDefault {
    public Corrente(Cliente cliente, String agencia, String senha) {
        super(cliente, TipoConta.CONTA_CORRENTE, agencia, senha);
    }




}
