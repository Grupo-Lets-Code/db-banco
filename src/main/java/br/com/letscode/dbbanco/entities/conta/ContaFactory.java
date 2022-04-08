package br.com.letscode.dbbanco.entities.conta;

import br.com.letscode.dbbanco.entities.cliente.TipoCliente;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ContaFactory {

    public BigDecimal valorTipoConta(Conta conta, BigDecimal valor) {
        var tipoConta = conta.getTipoConta();
        if(conta.getTipoCliente() == TipoCliente.PESSOA_JURIDICA){
            switch (tipoConta) {
                case CONTA_POUPANCA:
                    break;
                case CONTA_CORRENTE:
                    return valor.multiply(BigDecimal.valueOf(1.1));
                case CONTA_INVESTIMENTO:
                    break;
                default:
                   throw new IllegalArgumentException("Opção inválida!");
            }
        }
        return valor;
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
