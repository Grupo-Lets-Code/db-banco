package br.com.letscode.dbbanco.service;

import br.com.letscode.dbbanco.entities.Utils;
import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.conta.Conta;
import br.com.letscode.dbbanco.entities.conta.ContaFactory;
import br.com.letscode.dbbanco.entities.conta.TipoConta;
import br.com.letscode.dbbanco.exception.*;
import br.com.letscode.dbbanco.repository.ClienteRepository;
import br.com.letscode.dbbanco.repository.ContaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransacaoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransacaoService.class);
    private final ContaRepository contaRepository;


    public TransacaoService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public void sacar(Integer numeroConta, int senha, BigDecimal valor) {
        var optConta = contaRepository.findByNumeroContaAndSenha(numeroConta, senha);
        if (optConta.isPresent()) {
            Conta conta = optConta.get();
            // FIXME Refatorar ContaFactory para um nome mais descritivo
            var valorSaqueComTaxa = ContaFactory.valorTipoConta(conta, valor);
            BigDecimal result = conta.getSaldo().subtract(valorSaqueComTaxa);
            if (result.compareTo(BigDecimal.ZERO) < 0) {
                throw new ContaSaldoInsuficienteException();
            }
            conta.setSaldo(result);
            contaRepository.save(conta);
        } else throw new ContaAutenticacaoException();
    }

    public void depositar(Integer numeroConta, BigDecimal valor) {
        var optConta = contaRepository.findByNumeroConta(numeroConta);
        if (optConta.isPresent()) {
            Conta conta = optConta.get();
            conta.setSaldo(conta.getSaldo().add(valor));
            contaRepository.save(conta);
        } else throw new ContaNaoEncontradoException();
    }

    public void depositarInvestimento(Integer numeroConta, BigDecimal valor) {
        var optConta = contaRepository.findByNumeroConta(numeroConta);
        if (optConta.isPresent() && optConta.get().getTipoConta() == TipoConta.CONTA_INVESTIMENTO) {
            Conta conta = optConta.get();
            conta.setSaldo(conta.getSaldo().add(valor));
            contaRepository.save(conta);
        } else {
            throw new ContaInvalidaException();
        }

    }

    public void transferir(Integer contaOrigem, Integer contaDestino, int senha, BigDecimal valor) {
        var optContaOrigem = contaRepository.findByNumeroConta(contaOrigem);
        var optContaDestino = contaRepository.findByNumeroConta(contaDestino);

        if (optContaOrigem.isPresent() && optContaDestino.isPresent()) {
            this.sacar(contaOrigem, senha, valor);
            this.depositar(contaDestino, valor);
        } else throw new ContaNaoEncontradoException();
    }
}