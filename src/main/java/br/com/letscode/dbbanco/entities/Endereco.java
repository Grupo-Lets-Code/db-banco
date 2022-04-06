package br.com.letscode.dbbanco.entities;

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
    protected int cep;

    @JoinColumn(name="Cliente_ID", nullable = false)
    protected int cliente_id;



}
