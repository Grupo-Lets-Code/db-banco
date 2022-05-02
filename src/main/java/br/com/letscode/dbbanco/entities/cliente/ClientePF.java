package br.com.letscode.dbbanco.entities.cliente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "PESSOA_FISICA")
public class ClientePF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(nullable = false)
    @Pattern(regexp = "^\\d{3}.\\d{3}.\\d{3}-\\d{2}$", message = "Formato de CPF inválido - Formato esperado XXX.XXX.XXX-XX")
    protected String CPF;

    @Column(name = "data_nascimento", nullable = false)
    protected LocalDate dataNascimento;

    @OneToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    protected Cliente cliente;

    public ClientePF(String CPF, LocalDate dataNascimento, Cliente cliente) {
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClientePF clientePF = (ClientePF) o;
        return id != 0 && Objects.equals(id, clientePF.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}