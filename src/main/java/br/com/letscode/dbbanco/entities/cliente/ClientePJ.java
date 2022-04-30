package br.com.letscode.dbbanco.entities.cliente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PESSOA_JURIDICA")
public class ClientePJ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "CNPJ", nullable = false)
    @Pattern(regexp = "^\\d{14}$", message = "Formato de CNPJ inválido - registrar apenas números")
    protected String CNPJ;

    @Column(name = "Data_Abertura", nullable = false)
    @NotNull(message = "O cliente deve informar a data de abertura da empresa")
    protected LocalDate dataDeAbertura;

    @OneToOne
    @JoinColumn(name = "Cliente_ID", nullable = false)
    @NotNull(message = "O cliente pessoa jurídica deve estar associado à uma entidade cliente")
    protected Cliente cliente;

    public ClientePJ(String CNPJ, LocalDate dataDeAbertura, Cliente cliente) {
        this.CNPJ = CNPJ;
        this.dataDeAbertura = dataDeAbertura;
        this.cliente = cliente;
    }
}
