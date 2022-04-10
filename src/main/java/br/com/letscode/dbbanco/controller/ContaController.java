package br.com.letscode.dbbanco.controller;

import br.com.letscode.dbbanco.entities.Utils;
import br.com.letscode.dbbanco.entities.conta.Conta;
import br.com.letscode.dbbanco.entities.conta.ContaFactory;
import br.com.letscode.dbbanco.entities.conta.TipoConta;
import br.com.letscode.dbbanco.repository.ContaRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ContaController {
    private final ContaFactory contaFactory;
    private final ContaRepository contaRepository;
    private final Utils utilities;

    public ContaController(ContaFactory contaFactory, ContaRepository contaRepository, Utils utilities) {
        this.contaFactory = contaFactory;
        this.contaRepository = contaRepository;
        this.utilities = utilities;
    }

    public void criarConta(Conta criarConta) {
        contaRepository.save(criarConta);
        System.out.println("Conta Criada com sucesso!");
    }

    public boolean sacar(Integer numeroConta, int senha, BigDecimal valor) {
        if(this.validarLogin(numeroConta, senha)){
            var catConta = contaRepository.findByNumeroConta(numeroConta);
            var saldo = catConta.get().getSaldo();
            var valorCorrigido = contaFactory.valorTipoConta(catConta.get(), valor);
            var saldo_atual = saldo.subtract(valorCorrigido);
            if (saldo.compareTo(valorCorrigido) == 1) {
                catConta.get().setSaldo(saldo_atual);
                contaRepository.save(catConta.get());
                System.out.println("\nSaque no valor de " + valor + "R$ realizado com sucesso! Saldo atual: " + catConta.get().getSaldo());
                return true;
            } else {
                System.out.println("\nSaque no valor de " + valor + "R$ foi negado! Saldo atual: " + saldo);
                return false;
            }
        }else{
            System.out.println("Dados inválidos!");
            return false;
        }
    }

    public void depositar(Integer numeroConta, BigDecimal valor) {
        var catConta = contaRepository.findByNumeroConta(numeroConta);
        var saldo = catConta.get().getSaldo();
        var saldo_atual = saldo.add(valor);
        catConta.get().setSaldo(saldo_atual);
        contaRepository.save(catConta.get());
        System.out.println("\nDepósito no valor de " + valor + "R$ realizado com sucesso! Saldo atual: " + saldo_atual);
    }

    public boolean investir(Integer numeroConta, BigDecimal valor) {
        if(this.validarConta(numeroConta)){
            var catConta = contaRepository.findByNumeroConta(numeroConta);
            if( this.validarTipoConta(catConta.get().getTipoConta())){
                System.out.println("Conta não é do tipo Investimento!");
                return false;
            }
            var saldo = catConta.get().getSaldo();
            var valorCorrigido = contaFactory.valorTipoConta(catConta.get(), valor);
            var saldo_atual = saldo.add(valorCorrigido);
            catConta.get().setSaldo(saldo_atual);
            contaRepository.save(catConta.get());
            System.out.println("Investimento no valor R$" + valor + " realizado com sucesso!" + "saldo atual de R$" + catConta.get().getSaldo());
            return true;
        } else{
            System.out.println("Conta não encontrada para investimento!");
            return false;
        }

    }

    public boolean transferir(Integer contaRemetente, Integer contaDestinataria, int senha, BigDecimal valor) {
        if(this.validarLogin(contaRemetente, senha) && this.validarConta(contaDestinataria)){
            this.depositar(contaDestinataria, valor);
            this.sacar(contaRemetente, senha, valor);
            var catchContaRem = contaRepository.findByNumeroConta(contaRemetente);
            System.out.println("\nTransferência no valor de " + valor + "R$ realizada com sucesso! Saldo atual: " + catchContaRem.get().getSaldo());
            return true;
        }else{
            System.out.println("Conta destinatária ou remetente não encontrada!");
            return false;
        }
    }

    public boolean consultarSaldo(Integer numeroConta, int senha) {
        var catchConta = contaRepository.findByNumeroConta(numeroConta);
        var catchSenha = contaRepository.findBySenhaEquals(senha);
        if(catchConta.isPresent() && catchSenha.isPresent()){
            System.out.println("\nO saldo atual da conta é: R$" + catchConta.get().getSaldo());
            return true;
        } else{
            System.out.println("Conta não encontrada!");
            return false;
        }
    }

    public boolean validarLogin(Integer numeroConta, int senha) {
        var catchConta = contaRepository.findByNumeroConta(numeroConta);
        var catchSenha = contaRepository.findBySenhaEquals(senha);
        return catchConta.isPresent() && catchSenha.isPresent();
    }

    public boolean validarConta(Integer numeroConta) {
        var catchConta = contaRepository.findByNumeroConta(numeroConta);
        return catchConta.isPresent();
    }

    public void excluirConta(Integer numeroConta) {
        var catchConta = contaRepository.findByNumeroConta(numeroConta);
        if (catchConta.isPresent()) {
            contaRepository.deleteByNumeroConta(numeroConta);
            System.out.println("Conta EXCLUIDA com Sucesso!");
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }

    public boolean validarTipoConta(TipoConta tipoConta){
        return !(tipoConta == TipoConta.CONTA_INVESTIMENTO);
    }
}
