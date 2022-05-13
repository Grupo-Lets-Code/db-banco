package br.com.letscode.dbbanco.entities.cliente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PESSOA_JURIDICA")
public class ClientePJ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column
    @Pattern(regexp = "^\\d{2}.\\d{3}.\\d{3}/(0001|0002)-\\d{2}$", message = "Formato de CNPJ inválido - Formato esperado XX.XXX.XXX/0001-XX")
    protected String CNPJ;

    @Column(name = "data_abertura", nullable = false)
    protected LocalDate dataDeAbertura;

    @OneToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    protected Cliente cliente;

    public ClientePJ(String CNPJ, LocalDate dataDeAbertura, Cliente cliente) {
        this.CNPJ = CNPJ;
        this.dataDeAbertura = dataDeAbertura;
        this.cliente = cliente;
    }

    public ClientePJ(Integer id, String CNPJ, LocalDate dataDeAbertura, Cliente cliente) {
        this.id = id;
        this.CNPJ = CNPJ;
        this.dataDeAbertura = dataDeAbertura;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return cliente.toString() +
                "\nClientePJ ID: " + id +
                "\nCNPJ: " + CNPJ +
                "\nData de abertura: " + dataDeAbertura;
    }
}
