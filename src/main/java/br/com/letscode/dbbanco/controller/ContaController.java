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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/contas")
@Slf4j
public class ContaController {
    private final ContaService contaService;

    public ContaController(ContaService contaService){
        this.contaService = contaService;
    }

    @GetMapping("{conta}")
    public ResponseEntity selecionarContaByNumeroConta(@PathVariable("conta") Integer numeroConta){
        Conta conta = this.contaService.selecionaContaByNumeroConta(numeroConta);
        ResponseEntity response = new ResponseEntity(conta, HttpStatus.OK);
        return response;
    }
}
