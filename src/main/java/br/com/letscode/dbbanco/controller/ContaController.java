package br.com.letscode.dbbanco.controller;

import br.com.letscode.dbbanco.repository.ContaRepository;
import br.com.letscode.dbbanco.view.Menu;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ContaController {

    private final ContaRepository contaRepository;
    public ContaController(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public boolean sacar(Integer numeroConta, BigDecimal valor) {
        var catConta = contaRepository.findByNumeroConta(numeroConta);
        var saldo = catConta.get().getSaldo();
        //TODO Método recebe o valor e objeto retornado
        //TODO recebe o valor com taxa
        var saldo_atual = saldo.subtract(valor);

        if(saldo.compareTo(valor) == 1){
            catConta.get().setSaldo(saldo_atual);
            contaRepository.save(catConta.get());
            System.out.println("\nSaque no valor de " + valor + "R$ realizado com sucesso! Saldo atual: " + catConta.get().getSaldo());
            return true;
        } else{
            System.out.println("\nSaque no valor de " + valor + "R$ foi negado! Saldo atual: " + saldo);
            return false;
        }
    }

    public void depositar (Integer numeroConta, BigDecimal valor){
        var catConta = contaRepository.findByNumeroConta(numeroConta);
        var saldo = catConta.get().getSaldo();
        var saldo_atual = saldo.add(valor);
        catConta.get().setSaldo(saldo_atual);
        contaRepository.save(catConta.get());
        System.out.println("\nDepósito no valor de " + valor + "R$ realizado com sucesso! Saldo atual: " + saldo_atual);
    }

    public void investir (Integer numeroConta, BigDecimal valor){
        var catConta = contaRepository.findByNumeroConta(numeroConta);
        var saldo = catConta.get().getSaldo();
        var saldo_atual = saldo.add(valor);
        catConta.get().setSaldo(saldo_atual);
    }

    public void transferir(Integer contaRemetente, Integer contaDestinataria, int senha, BigDecimal valor) {
        var catContaRemetente = contaRepository.findByNumeroConta(contaRemetente);
        var catContaDestinataria = contaRepository.findByNumeroConta(contaDestinataria);

        var catSaldoRemetente = catContaRemetente.get().getSaldo();
        var saldoRemetente = catSaldoRemetente.subtract(valor);

        var catSaldoDestinataria = catContaDestinataria.get().getSaldo();
        var saldoDestinataria = catSaldoDestinataria.add(valor);

    }

    public void consultarSaldo(Integer numeroConta, int senha) {
        var catConta = contaRepository.findByNumeroConta(numeroConta);
        var catSenha = contaRepository.findBySenhaEquals(senha);
    }

    public boolean validarLogin(Integer numeroConta, int senha) {
        var catchConta = contaRepository.findByNumeroConta(numeroConta);
        var catchSenha = contaRepository.findBySenhaEquals(senha);
        if(catchConta.isPresent() && catchSenha.isPresent()){
            return true;
        } else{
            return false;
        }
    }

    public boolean validarConta(Integer numeroConta) {
        var catchConta = contaRepository.findByNumeroConta(numeroConta);
        if(catchConta.isPresent()){
            return true;
        } else{
            return false;
        }
    }

}
