package br.com.letscode.dbbanco.entities.cliente;

import lombok.*;

import javax.persistence.*;
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

    @Column(name = "CPF", nullable = false, length = 11)
    protected String CPF;

    @Column(name = "data_nascimento", nullable = false)
    protected LocalDate dataNascimento;

    @OneToOne
    @JoinColumn(name = "Cliente_ID", nullable = false)
    protected Cliente cliente;

    public ClientePF(String CPF, LocalDate dataNascimento, Cliente cliente) {
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.cliente = cliente;
    }

}