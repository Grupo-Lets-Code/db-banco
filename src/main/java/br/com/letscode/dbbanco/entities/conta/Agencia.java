package br.com.letscode.dbbanco.entities.conta;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Agencia agencia = (Agencia) o;
        return id != null && Objects.equals(id, agencia.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
