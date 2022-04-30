package br.com.letscode.dbbanco.entities.cliente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    @NotBlank(message = "O nome do cliente deve ser cadastrado")
    protected String nome;

    @Column
    private String email;

    @Column
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