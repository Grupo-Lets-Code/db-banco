package br.com.letscode.dbbanco.controller;


import br.com.letscode.dbbanco.entities.Endereco;
import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.repository.EnderecoRepository;
import org.springframework.stereotype.Component;

import java.util.Scanner;




@Component
public class EnderecoController {

    private final EnderecoRepository enderecoRepository;

    public EnderecoController(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }


    public void createEndereco(String logradouro, String numero, String cidade, String bairro, String uf, String pais, int cep, Cliente cliente){
        var criarEnd = new Endereco(logradouro,numero,cidade,bairro,uf,pais,cep,cliente);
        enderecoRepository.save(criarEnd);
    }



}


// public static void MapearEndereco(){



//     System.out.println("Digite o logradouro:");
//     String lagradouro = input.next();

//     System.out.println("Digite o numero:");
//     String numero = input.next();

//     System.out.println("Digite a cidade:");
//     String cidade = input.nextLine();

//     System.out.println("Digite o bairro:");
//     String bairro = input.nextLine();

//     System.out.println("Digite o estado:");
//     String estado = input.nextLine();

//     System.out.println("Digite o pais:");
//     String pais = input.nextLine();

//     System.out.println("Digite o cep (Só os números):");
//     int cep = input.nextInt();

//     var criarCliente = new Cliente("Rafael","rafael@gmail.com","11977507307");
//     var criarEndereco = new Endereco(lagradouro,numero,cidade,bairro,estado,pais,cep, criarCliente);


// }

