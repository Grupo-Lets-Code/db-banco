package br.com.letscode.dbbanco.controller;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.cliente.ClientePF;
<<<<<<< HEAD
import br.com.letscode.dbbanco.entities.cliente.ClientePJ;
=======
import br.com.letscode.dbbanco.exception.ClienteDuplicadoException;
import br.com.letscode.dbbanco.exception.ClienteNaoEncontradoException;
>>>>>>> fdb3deb (Add ExceptionHandler Cliente)
import br.com.letscode.dbbanco.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    public ResponseEntity<Cliente> selecionarClienteById(@PathVariable("cliente") Integer idCliente) {
        Cliente cliente = this.clienteService.selecionaClienteById(idCliente);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping("novo")
    public ResponseEntity<String> salvarCliente(@Valid @RequestBody Cliente cliente){
        this.clienteService.salvarCliente(cliente);
        return new ResponseEntity<>("Cliente cadastrado com sucesso", HttpStatus.CREATED);
    }

    @PostMapping("novo-pf")
    public ResponseEntity<String> salvarClientePF(@Valid @RequestBody ClientePF clientePF) {
        int ClienteID = clientePF.getCliente().getId();

        if (!this.clienteService.existsById(ClienteID))
            return new ResponseEntity<>("Cliente base de ID " + ClienteID + " não encontrado", HttpStatus.BAD_REQUEST);

        this.clienteService.salvarClientePF(clientePF);
        return new ResponseEntity<>("Cliente Pessoa Física cadastrado com sucesso", HttpStatus.CREATED);
    }

    @PostMapping("novo-pj")
    public ResponseEntity<String> salvarClientePJ(@Valid @RequestBody ClientePJ clientePJ) {
        int ClienteID = clientePJ.getCliente().getId();

        if (!this.clienteService.existsById(ClienteID))
            return new ResponseEntity<>("Cliente base de ID " + ClienteID + " não encontrado", HttpStatus.BAD_REQUEST);

        this.clienteService.salvarClientePJ(clientePJ);
        return new ResponseEntity<>("Cliente Pessoa Jurídica cadastrado com sucesso", HttpStatus.CREATED);
    }
    @ExceptionHandler
    public ResponseEntity tratarClienteNaoEncontrado(ClienteNaoEncontradoException e) {
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        return response;
    }
    @ExceptionHandler
    public ResponseEntity tratarClienteDuplicado(ClienteDuplicadoException e) {
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        return response;
    }
}