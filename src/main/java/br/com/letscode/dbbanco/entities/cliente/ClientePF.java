package br.com.letscode.dbbanco.entities.cliente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
public class ClientePF extends Cliente {

    protected String CPF;

    public ClientePF(String nome, String CPF) {
        super();
    }

    // teste

}
