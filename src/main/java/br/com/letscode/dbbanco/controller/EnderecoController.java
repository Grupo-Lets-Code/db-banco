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


    public void createEndereco(String logradouro, String numero, String cidade, String bairro, String uf, String pais, String cep, Cliente cliente){
        var criarEnd = new Endereco(logradouro,numero,cidade,bairro,uf,pais,cep,cliente);
        enderecoRepository.save(criarEnd);
        System.out.printf("Endereco salvo com sucesso!!!");
    }



}




