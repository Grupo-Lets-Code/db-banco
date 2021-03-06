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

    public boolean sacar(Integer numeroConta, int senha, BigDecimal valor, boolean exibir) {
        if(this.validarLogin(numeroConta, senha)){
            var catchConta = contaRepository.findByNumeroContaAndSenha(numeroConta, senha);
            var saldo = catchConta.get().getSaldo();
            var valorCorrigido = contaFactory.valorTipoConta(catchConta.get(), valor);
            var saldo_atual = saldo.subtract(valorCorrigido);
            if (saldo.compareTo(valorCorrigido) == 1) {
                catchConta.get().setSaldo(saldo_atual);
                contaRepository.save(catchConta.get());
                if(exibir)
                System.out.println("\nSaque no valor de R$ " + utilities.FormatValor(valor) + " realizado com sucesso! Saldo atual: " + catchConta.get().getSaldo());
                return true;
            } else {
                if(exibir)
                System.out.println("\nSaque no valor de R$ " + utilities.FormatValor(valor) + " foi negado! Saldo atual: " + utilities.FormatValor(saldo));
                return false;
            }
        }else{
            System.out.println("Dados inv??lidos!");
            return false;
        }
    }

    public void depositar(Integer numeroConta, BigDecimal valor, boolean exibir) {
        var catchConta = contaRepository.findByNumeroConta(numeroConta);
        var saldo = catchConta.get().getSaldo();
        var saldo_atual = saldo.add(valor);
        catchConta.get().setSaldo(saldo_atual);
        contaRepository.save(catchConta.get());
        if(exibir)
        System.out.println("\nDep??sito no valor de R$ " + utilities.FormatValor(valor) + " realizado com sucesso! Saldo atual: " + utilities.FormatValor(saldo_atual));
    }

    public boolean investir(Integer numeroConta, BigDecimal valor) {
        if(this.validarConta(numeroConta)){
            var catchConta = contaRepository.findByNumeroConta(numeroConta);
            if( this.validarTipoConta(catchConta.get().getTipoConta())){
                System.out.println("Conta n??o ?? do tipo Investimento!");
                return false;
            }
            var saldo = catchConta.get().getSaldo();
            var valorCorrigido = contaFactory.valorTipoConta(catchConta.get(), valor);
            var saldo_atual = saldo.add(valorCorrigido);
            catchConta.get().setSaldo(saldo_atual);
            contaRepository.save(catchConta.get());
            System.out.println("Investimento no valor R$ " + utilities.FormatValor(valor) + " realizado com sucesso!" + "saldo atual de R$" + catchConta.get().getSaldo());
            return true;
        } else{
            System.out.println("Conta n??o encontrada para investimento!");
            return false;
        }

    }

    public Conta recuperaContaPorNumero(Integer numeroConta){
        return contaRepository.findByNumeroConta(numeroConta).get();
    }

    public boolean transferir(Integer contaRemetente, Integer contaDestinataria, int senha, BigDecimal valor) {
        if(this.validarLogin(contaRemetente, senha) && this.validarConta(contaDestinataria)){
            this.depositar(contaDestinataria, valor, false);
            this.sacar(contaRemetente, senha, valor, false);
            var catchContaRem = contaRepository.findByNumeroConta(contaRemetente);
            System.out.println("\nTransfer??ncia no valor de R$ " + utilities.FormatValor(valor) + " realizada com sucesso! Saldo atual: " + catchContaRem.get().getSaldo());
            return true;
        }else{
            System.out.println("Conta destinat??ria ou remetente n??o encontrada!");
            return false;
        }
    }

    public boolean consultarSaldo(Integer numeroConta, int senha) {
        var catchContaAndSenha = contaRepository.findByNumeroContaAndSenha(numeroConta, senha);
        if(catchContaAndSenha.isPresent()){
            System.out.println("\nO saldo atual da conta ??: R$" + catchContaAndSenha.get().getSaldo());
            return true;
        } else{
            System.out.println("Conta n??o encontrada!");
            return false;
        }
    }

    public boolean validarLogin(Integer numeroConta, int senha) {
        var catchContaAndSenha = contaRepository.findByNumeroContaAndSenha(numeroConta, senha);
        return catchContaAndSenha.isPresent();
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
            System.out.println("Conta n??o encontrada!");
        }
    }

    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }

    public boolean validarTipoConta(TipoConta tipoConta){
        return !(tipoConta == TipoConta.CONTA_INVESTIMENTO);
    }

}
