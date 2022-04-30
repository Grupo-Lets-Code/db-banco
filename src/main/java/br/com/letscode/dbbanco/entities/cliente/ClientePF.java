package br.com.letscode.dbbanco.entities.cliente;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
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

}