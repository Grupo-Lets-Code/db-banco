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

    // Agencias que podem ser escolhidas pelo usuário nas opções:
    // 505 = Norte
    // 404 = Nordeste
    // 101 = Sul
    // 202 = Sudeste
    // 303 = Centro-Oeste
    // Salvar no data.sql

}
