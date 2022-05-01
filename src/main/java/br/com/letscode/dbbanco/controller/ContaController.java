package br.com.letscode.dbbanco.controller;


import br.com.letscode.dbbanco.entities.Utils;
import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.conta.Conta;
import br.com.letscode.dbbanco.entities.conta.ContaFactory;
import br.com.letscode.dbbanco.entities.conta.TipoConta;
import br.com.letscode.dbbanco.repository.ContaRepository;

import br.com.letscode.dbbanco.service.ClienteService;
import br.com.letscode.dbbanco.service.ContaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/contas")
@Slf4j
public class ContaController {
    private final ContaService contaService;
    private final ClienteService clienteService;

    public ContaController(ContaService contaService, ClienteService clienteService){
        this.contaService = contaService;
        this.clienteService = clienteService;
    }

    @PostMapping("novo")
    public ResponseEntity<String> criarConta(@Valid @RequestBody Conta conta) {
        int ClienteID = conta.getCliente().getId();

        if (!this.clienteService.existsById(ClienteID))
            return new ResponseEntity<>("Cliente base de ID " + ClienteID + " não encontrado", HttpStatus.BAD_REQUEST);

        this.contaService.criarConta(conta);
        return new ResponseEntity<>("Conta cadastrada com sucesso", HttpStatus.CREATED);
    }

    @GetMapping("cliente-{id}")
    public ResponseEntity<List<Conta>> selecionarContaPorCliente(@PathVariable("id") Integer clienteID) {
        List<Conta> contas = this.contaService.selecionaContasPorClienteID(clienteID);
        return new ResponseEntity<>(contas, HttpStatus.OK);
    }

    @GetMapping("{conta}")
    public ResponseEntity selecionarContaByNumeroConta(@PathVariable("conta") Integer numeroConta){
        Conta conta = this.contaService.selecionaContaByNumeroConta(numeroConta);
        ResponseEntity response = new ResponseEntity(conta, HttpStatus.OK);
        return response;
    }
}
