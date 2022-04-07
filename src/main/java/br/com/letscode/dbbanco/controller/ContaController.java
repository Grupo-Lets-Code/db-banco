package br.com.letscode.dbbanco.controller;

import br.com.letscode.dbbanco.repository.ContaRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ContaController {
    private final ContaRepository contaRepository;

    public ContaController(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }


    public void sacar(Integer numeroConta, int senha, BigDecimal valor) {
        var catConta = contaRepository.findByNumeroConta(numeroConta);
        var saldo = catConta.get().getSaldo();
        var saldo_atual = saldo.subtract(valor);
        catConta.get().setSaldo(saldo_atual);
    }

    public void depositar (Integer numeroConta, BigDecimal valor){
        var catConta = contaRepository.findByNumeroConta(numeroConta);
        var saldo = catConta.get().getSaldo();
        var saldo_atual = saldo.add(valor);
        catConta.get().setSaldo(saldo_atual);
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
}
