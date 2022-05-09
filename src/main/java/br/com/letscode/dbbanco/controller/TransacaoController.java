package br.com.letscode.dbbanco.controller;

import br.com.letscode.dbbanco.dtos.DepositoRequestDTO;
import br.com.letscode.dbbanco.dtos.SaqueRequestDTO;
import br.com.letscode.dbbanco.dtos.TransferenciaRequestDTO;
import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.cliente.ClientePF;
import br.com.letscode.dbbanco.entities.cliente.ClientePJ;
import br.com.letscode.dbbanco.service.ClienteService;
import br.com.letscode.dbbanco.service.TransacaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/transacao")
@Slf4j
public class TransacaoController {
    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    /*@PostMapping("/saque")
    public ResponseEntity saque(@Valid @RequestBody SaqueRequestDTO saqueRequest) {
        transacaoService.sacar(saqueRequest.getNumeroConta(), saqueRequest.getSenha(), saqueRequest.getValor());

        ResponseEntity response = new ResponseEntity("Saque relizado com sucesso!", HttpStatus.OK);
        return response;
    }

    @PostMapping("/deposito")
    public ResponseEntity deposito(@Valid @RequestBody DepositoRequestDTO depositoRequest) {
        transacaoService.depositar(depositoRequest.getNumeroConta(), depositoRequest.getValor());

        ResponseEntity response = new ResponseEntity("Depósito relizado com sucesso!", HttpStatus.OK);
        return response;
    }
    @PostMapping("/depositoInvestimento")
    public ResponseEntity depositoInvestimento(@Valid @RequestBody DepositoRequestDTO depositoRequest) {
        transacaoService.depositarInvestimento(depositoRequest.getNumeroConta(), depositoRequest.getValor());

        ResponseEntity response = new ResponseEntity("Depósito relizado com sucesso!", HttpStatus.OK);
        return response;
    }

    @PostMapping("/transferencia")
    public ResponseEntity transferencia(@Valid @RequestBody TransferenciaRequestDTO transferenciaRequest) {
        transacaoService.transferir(transferenciaRequest.getContaOrigem(), transferenciaRequest.getContaDestino(),
                transferenciaRequest.getSenha(), transferenciaRequest.getValor());

        ResponseEntity response = new ResponseEntity("Transferência relizada com sucesso!", HttpStatus.OK);
        return response;
    }*/

}