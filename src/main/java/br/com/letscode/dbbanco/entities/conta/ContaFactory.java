package br.com.letscode.dbbanco.entities.conta;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.repository.ContaPoupancaRepository;
import br.com.letscode.dbbanco.repository.ContaRepository;

import java.math.BigDecimal;

public class ContaFactory {

    public BigDecimal valorTipoConta(Conta conta, BigDecimal valor/*, TODO*/) {
        var tipoConta = conta.getTipoConta();

        switch (tipoConta) {
            case CONTA_POUPANCA:

            case CONTA_CORRENTE:
                var valorComTaxa = valor.multiply(BigDecimal.valueOf(0.02));
                return valorComTaxa;
            case CONTA_INVESTIMENTO:

            default:
                throw new IllegalArgumentException("Opção inválida!");
        }
    }
    /*
    public static ContaDefault create(Cliente cliente, TipoConta tipoConta, String agencia,
                                      String senha) {
        var clientePF =  new ContaDefault(Cliente cliente, TipoConta tipoConta,
                String agencia, String senha);

        switch (tipoConta) {
            case CONTA_POUPANCA:
                var contaPoupancaRepository = ContaPoupancaRepository;
                return ContaPoupancaRepository.save(cliente);
                //this.contaRepository.save(cliente);

            //private static ContaDefault createContaPoupanca(Cliente cliente, TipoConta tipoConta, String agencia,
            //String senha, ContaRepository contaRepository) {

            //return ContaRepository.save(return ContaRepository.save(new ContaDefault(Cliente cliente, TipoConta tipoConta,
            //String agencia, String senha));

            //new Poupanca(cliente);
            }

            private static ContaDefault createContaCorrente(Cliente cliente) {
                return new Corrente(cliente);
            }

            private static ContaDefault createContaInvestimento(Cliente cliente) {
                return new Investimento(cliente);
            }

        }
    }

     */
    }
