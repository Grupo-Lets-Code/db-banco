package br.com.letscode.dbbanco.entities.cliente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column
    @NotBlank(message = "Um cliente não pode ter um nome vazio")
    protected String nome;

    @Column
    @Email(message = "Formato de e-mail inválido")
    private String email;

    @Column
    @Pattern(regexp = "^\\(\\d{2}\\)\\s?\\d?\\d{4}-?\\d{4}$", message = "Formato de telefone inválido - Formato esperado (XX) XXXXX-XXXX")
    @NotBlank(message = "Telefone não Informado")
    private String telefone;

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "\nCliente ID: " + id +
                "\nNome: " + nome +
                "\nEmail: " + email +
                "\nTelefone: " + telefone;
    }
}