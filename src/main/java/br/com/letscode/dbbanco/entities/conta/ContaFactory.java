/*package br.com.letscode.dbbanco.entities.conta;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.repository.ContaPoupancaRepository;
import br.com.letscode.dbbanco.repository.ContaRepository;

public class ContaFactory {

    private static final ContaRepository contaRepository;
    private static final ContaPoupancaRepository contaPoupancaRepository;

    private ContaFactory(ContaRepository contaRepository) {
        super();
        this.contaRepository = contaRepository;
    }

    public static ContaDefault create(Cliente cliente, TipoConta tipoConta) {
        switch (tipoConta) {
            case CONTA_POUPANCA:
                return createContaPoupanca(cliente);
                        //this.contaRepository.save(cliente);
            case CONTA_CORRENTE:
                return createContaCorrente(cliente);
            case CONTA_INVESTIMENTO:
                return createContaInvestimento(cliente);
            default:
                throw new IllegalArgumentException("Opção inválida!");
        }
    }

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
    }*/
