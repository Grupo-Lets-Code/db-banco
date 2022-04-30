package br.com.letscode.dbbanco.controller;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.cliente.ClientePF;
import service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/clientes")
@Slf4j
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping("{cliente}")
    public ResponseEntity selecionarClienteById(@PathVariable("cliente") Integer idCliente){
        Cliente cliente = this.clienteService.selecionaClienteById(idCliente);
        ResponseEntity response = new ResponseEntity(cliente, HttpStatus.OK);
        return response;
    }

    @PostMapping
    public ResponseEntity salvarCliente(@Valid @RequestBody Cliente cliente){
        System.out.println(cliente.toString());
        this.clienteService.salvarCliente(cliente);
        ResponseEntity response = new ResponseEntity("Aluno criado com sucesso", HttpStatus.CREATED);
        return response;
    }

    @PostMapping("/pf")
    public String salvarClientePF(@Valid ClientePF cliente, BindingResult result){
        if(result.hasErrors()){
            return "formulariocliente";
        }
        this.clienteService.salvarClientePF(cliente);
        return "redirect:/clientes";
    }
}