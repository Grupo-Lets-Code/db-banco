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


    public void createEndereco(Endereco endereco){
        enderecoRepository.save(endereco);
        System.out.printf("Cadastro de endereco realizado, escolha o tipo conta: \n");
    }



}




