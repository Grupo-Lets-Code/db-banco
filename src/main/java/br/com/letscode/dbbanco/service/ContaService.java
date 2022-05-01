package br.com.letscode.dbbanco.service;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.conta.Conta;
import br.com.letscode.dbbanco.exception.ClienteNaoEncontradoException;
import br.com.letscode.dbbanco.exception.ContaNaoEncontradoException;
import br.com.letscode.dbbanco.repository.ContaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContaService.class);
    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public void criarConta(Conta conta) {
        contaRepository.save(conta);
    }

    public Conta selecionaContaByNumeroConta(Integer numeroConta){
        LOGGER.info("Procurando conta do id ", numeroConta, ".");
        return this.contaRepository.findByNumeroConta(numeroConta).orElseThrow(() -> {LOGGER.error("500 - Erro ao realizar requisição de Conta"); return new ContaNaoEncontradoException();});
    }

    /*public boolean sacar(Integer numeroConta, int senha, BigDecimal valor, boolean exibir) {
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
            System.out.println("Dados inválidos!");
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
        System.out.println("\nDepósito no valor de R$ " + utilities.FormatValor(valor) + " realizado com sucesso! Saldo atual: " + utilities.FormatValor(saldo_atual));
    }

    public boolean investir(Integer numeroConta, BigDecimal valor) {
        if(this.validarConta(numeroConta)){
            var catchConta = contaRepository.findByNumeroConta(numeroConta);
            if( this.validarTipoConta(catchConta.get().getTipoConta())){
                System.out.println("Conta não é do tipo Investimento!");
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
            System.out.println("Conta não encontrada para investimento!");
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
            System.out.println("\nTransferência no valor de R$ " + utilities.FormatValor(valor) + " realizada com sucesso! Saldo atual: " + catchContaRem.get().getSaldo());
            return true;
        }else{
            System.out.println("Conta destinatária ou remetente não encontrada!");
            return false;
        }
    }

    public boolean consultarSaldo(Integer numeroConta, int senha) {
        var catchContaAndSenha = contaRepository.findByNumeroContaAndSenha(numeroConta, senha);
        if(catchContaAndSenha.isPresent()){
            System.out.println("\nO saldo atual da conta é: R$" + catchContaAndSenha.get().getSaldo());
            return true;
        } else{
            System.out.println("Conta não encontrada!");
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
            System.out.println("Conta não encontrada!");
        }
    }

    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }

    public boolean validarTipoConta(TipoConta tipoConta){
        return !(tipoConta == TipoConta.CONTA_INVESTIMENTO);
    }
*/
}
