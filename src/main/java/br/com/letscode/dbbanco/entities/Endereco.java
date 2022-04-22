package br.com.letscode.dbbanco.entities;


import br.com.letscode.dbbanco.entities.cliente.Cliente;
import lombok.*;

import javax.persistence.*;


@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Endereco{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    protected int id;

    @Column(nullable = false)
    protected String logradouro;

    @Column(nullable = false)
    protected String numero;

    @Column(nullable = false)
    protected String cidade;

    @Column(nullable = false)
    protected String bairro;

    @Column(nullable = false)
    protected String uf;

    @Column(nullable = false)
    protected String pais;

    @Column(nullable = false)
    protected String cep;

    @OneToOne
    @JoinColumn(name="Cliente_ID", nullable = false)
    protected Cliente cliente;

    public Endereco(String logradouro, String numero, String cidade, String bairro, String uf, String pais, String cep, Cliente cliente) {

        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.bairro = bairro;
        this.uf = uf;
        this.pais = pais;
        this.cep = cep;
        this.cliente = cliente;
    }
}