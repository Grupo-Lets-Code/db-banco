package br.com.letscode.dbbanco.entities.conta;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@ToString
@Entity
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private Integer numeroAgencia;
    private String nome;

    public Agencia(Integer numeroAgencia, String nome) {
        this.numeroAgencia = numeroAgencia;
        this.nome = nome;
    }

    // Agencia escolhida pelo usuário opções:

    // 0001 = Norte
    // 0005 = Nordeste
    // 0010 = Sul
    // 0020 = Sudeste
    // 0030 = Centro-Oeste

    // Salvar no data.sql

}
