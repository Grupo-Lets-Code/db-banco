package br.com.letscode.dbbanco.controller;


import br.com.letscode.dbbanco.entities.Endereco;
import br.com.letscode.dbbanco.repository.EnderecoRepository;
import org.springframework.stereotype.Component;

@Component
public class EnderecoController {

    private final EnderecoRepository enderecoRepository;

    public EnderecoController(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public void updateEndereco(Endereco endereco) {
        enderecoRepository.save(endereco);
        System.out.println("Alteração de endereco realizado!\n");
    }

    public void createEndereco(Endereco endereco){
        enderecoRepository.save(endereco);
        System.out.println("Cadastro de endereco realizado, escolha o tipo conta: \n");
    }

    public Endereco recuperaEnderecoPorId(Integer idEndereco) {
        return enderecoRepository.findById(idEndereco).get();
    }
}




