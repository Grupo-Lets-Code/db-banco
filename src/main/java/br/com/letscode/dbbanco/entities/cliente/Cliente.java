package br.com.letscode.dbbanco.entities.cliente;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column
    @NotBlank(message = "Um cliente não pode ter um nome vazio")
    protected String nome;

    @Column
    @NotBlank
    @Email(message = "Formato de e-mail inválido - ex: email@email.com")
    private String email;

    @Column
    @NotBlank
    @Pattern(regexp = "^\\(\\d{2}\\)\\s?\\d?\\d{4}-?\\d{4}$", message = "Formato de telefone inválido - Formato esperado (XX) XXXXX-XXXX")
    private String telefone;

    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Cliente(Integer id, String nome, String email, String telefone) {
        this.id = id;
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