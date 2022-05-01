package br.com.letscode.dbbanco.service;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.cliente.ClientePF;
import br.com.letscode.dbbanco.exception.ClienteNaoEncontradoException;
import br.com.letscode.dbbanco.repository.ClientePFRepository;
import br.com.letscode.dbbanco.repository.ClientePJRepository;
import br.com.letscode.dbbanco.repository.ClienteRepository;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteService.class);
    private final ClienteRepository clienteRepository;
    private final ClientePFRepository clientePFRepository;
    private final ClientePJRepository clientePJRepository;

    public ClienteService(ClienteRepository clienteRepository,
                          ClientePFRepository clientePFRepository, ClientePJRepository clientePJRepository) {
        this.clienteRepository = clienteRepository;
        this.clientePFRepository = clientePFRepository;
        this.clientePJRepository = clientePJRepository;
    }

    public Cliente salvarCliente(Cliente cliente){
        if(!this.clienteRepository.existsById(cliente.getId())){
            LOGGER.info("Requisição de Novo Cliente Aceita");
            return this.clienteRepository.save(cliente);
        } else {
            throw new ClienteNaoEncontradoException();
        }
    }

    public ClientePF salvarClientePF(ClientePF cliente){
        if(!this.clientePFRepository.existsById(cliente.getId())){
            LOGGER.info("Requisição de Novo Cliente Aceita");
            return this.clientePFRepository.save(cliente);
        } else {
            throw new ClienteNaoEncontradoException();
        }
    }

    public Cliente selecionaClienteById(Integer idCliente){
        LOGGER.info("Procurando cliente do id ", idCliente, ".");
        return this.clienteRepository.findById(idCliente).orElseThrow(() -> {LOGGER.error("Erro ao realizar requisição de Cliente"); return new ClienteNaoEncontradoException();});
    }

    /*public Cliente createPF(String nome, String email, String telefone, String cpf, LocalDate data_nascimento) {
        var createCliente = new Cliente(nome, email, telefone);
        var cliente = clienteRepository.save(createCliente);

        var createClientePF = new ClientePF(cpf, data_nascimento, createCliente);
        clientePFRepository.save(createClientePF);
        System.out.println("Cadastrado de cliente realizado, siga para a criação de conta!\n");
        return cliente;
    }

    public Cliente createPJ(String nome, String email, String telefone, String cnpj, LocalDate data_abertura) {
        var createCliente = new Cliente(nome, email, telefone);
        var cliente = clienteRepository.save(createCliente);

        var createClientePJ = new ClientePJ(cnpj, data_abertura, createCliente);
        clientePJRepository.save(createClientePJ);
        System.out.println("Cadastrado de cliente realizado, siga para a criação de conta!\n");
        return cliente;
    }*/
}
