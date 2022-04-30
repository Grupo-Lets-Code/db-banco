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

    @Column
    @Pattern(regexp = "^\\d{11}$", message = "Formato de CPF inválido - registrar apenas números")
    protected String CPF;

    @Column(name = "data_nascimento", nullable = false)
    @NotNull(message = "O cliente deve informar a data de nascimento")
    protected LocalDate dataNascimento;

    @OneToOne
    @JoinColumn(name = "Cliente_ID", nullable = false)
    @NotNull(message = "O cliente pessoa física deve estar associado à uma entidade cliente")
    protected Cliente cliente;

    public ClientePF(String CPF, LocalDate dataNascimento, Cliente cliente) {
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.cliente = cliente;
    }

}