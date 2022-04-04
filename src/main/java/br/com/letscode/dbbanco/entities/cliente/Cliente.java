package br.com.letscode.dbbanco.entities.cliente;

import javax.persistence.*;

@Entity
@MappedSuperclass
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String nome;

    public Cliente() {
    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "\nPessoa" +
                "\nNome: " + this.getNome();
    }

}