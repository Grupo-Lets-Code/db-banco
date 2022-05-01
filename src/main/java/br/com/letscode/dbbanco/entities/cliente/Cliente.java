package br.com.letscode.dbbanco.entities.cliente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
<<<<<<< HEAD
<<<<<<< HEAD
import javax.validation.Valid;
import javax.validation.constraints.*;
=======
import javax.validation.constraints.NotBlank;
>>>>>>> 3d47343 (Add ClienteAdvice and ExceptionHandler)
=======
import javax.validation.constraints.NotBlank;
>>>>>>> 3d473439d597332712692af74bfd7e19985546a0

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
<<<<<<< HEAD
<<<<<<< HEAD
    @NotBlank(message = "Um cliente não pode ter um nome vazio")
    protected String nome;

    @Column
    @Email(message = "Formato de e-mail inválido")
    private String email;

    @Column
    @Pattern(regexp = "^\\(\\d{2}\\)\\s?\\d?\\d{4}-?\\d{4}$", message = "Formato de telefone inválido - Formato esperado (XX) XXXXX-XXXX")
=======
    @NotBlank(message = "Nome não Informado")
    protected String nome;

    @Column
    @NotBlank(message = "E-mail não Informado")
    private String email;

    @Column
    @NotBlank(message = "Telefone não Informado")
>>>>>>> 3d47343 (Add ClienteAdvice and ExceptionHandler)
=======
    @NotBlank(message = "Nome não Informado")
    protected String nome;

    @Column
    @NotBlank(message = "E-mail não Informado")
    private String email;

    @Column
    @NotBlank(message = "Telefone não Informado")
>>>>>>> 3d473439d597332712692af74bfd7e19985546a0
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