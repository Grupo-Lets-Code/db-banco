package br.com.letscode.dbbanco.entities;

import javax.persistence.*;

@Entity
public class Endereco{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    protected int endereco_id_pk;
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
    protected int cep;
    @JoinColumn(name="Cliente_ID", nullable = false)
    protected int cliente_id;


}
