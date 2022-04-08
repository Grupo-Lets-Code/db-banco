package br.com.letscode.dbbanco.entities.cliente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PESSOA JURIDICA")
public class ClientePJ{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "CNPJ", nullable = false)
    protected String CNPJ;

    @Column(name = "Data de Abertura", nullable = false)
    protected LocalDate dataDeAbertura;

    @OneToOne
    @JoinColumn(name = "Cliente_ID", nullable = false)
    protected Cliente cliente;

    public ClientePJ(String CNPJ, LocalDate dataDeAbertura, Cliente cliente) {
        this.CNPJ = CNPJ;
        this.dataDeAbertura = dataDeAbertura;
        this.cliente = cliente;
    }
}
