package br.com.letscode.dbbanco.view.conta;

import br.com.letscode.dbbanco.controller.ContaController;
import br.com.letscode.dbbanco.entities.Endereco;
import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.cliente.TipoCliente;
import br.com.letscode.dbbanco.entities.conta.Conta;
import br.com.letscode.dbbanco.entities.conta.TipoConta;
import br.com.letscode.dbbanco.view.Menu;
import br.com.letscode.dbbanco.view.agencia.AgenciaView;
import br.com.letscode.dbbanco.view.pessoa.PessoaView;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ContaView {

    private final Menu menu;
    private final PessoaView pessoaView;
    private final AgenciaView agenciaView;
    private final ContaController contaController;

    public ContaView(@Lazy Menu menu, PessoaView pessoaView, ContaController contaController,
                     AgenciaView agenciaView) {
        this.menu = menu;
        this.pessoaView = pessoaView;
        this.contaController = contaController;
        this.agenciaView = agenciaView;
    }

    public void painelContasPJ(Cliente cliente, Endereco endereco) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n|    Opção 1 - Conta Corrente           |");
        System.out.println("|    Opção 2 - Conta Investimento       |");
        System.out.println("|    Opção 3 - Voltar                   |");

        String validador = input.nextLine();
        int tipoContaPJ = 0;

        try{
            tipoContaPJ = Integer.parseInt(validador);
            switch (tipoContaPJ) {
                case 1:
                    criarConta(cliente, TipoConta.CONTA_CORRENTE, TipoCliente.PESSOA_JURIDICA, endereco);
                    break;
                case 2:
                    criarConta(cliente, TipoConta.CONTA_INVESTIMENTO, TipoCliente.PESSOA_JURIDICA, endereco);
                    break;
                case 3:
                    pessoaView.painelPessoa();
                    break;
                default:
                    System.out.println("Opção inválida!\n");
                    painelContasPJ(cliente, endereco);
                    break;
            }
        } catch (Exception e){
            System.out.println("Código Inválido\n");
            painelContasPJ(cliente, endereco);
        }


    }

    public void painelContasPF(Cliente cliente, Endereco endereco) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n|    Opção 1 - Conta Corrente           |");
        System.out.println("|    Opção 2 - Conta Poupança           |");
        System.out.println("|    Opção 3 - Conta Investimento       |");
        System.out.println("|    Opção 4 - Voltar                   |");

        String validador = input.nextLine();
        int tipoConta = 0;

        if (validador.matches("\\d")){
            tipoConta = Integer.parseInt(validador);
            switch (tipoConta) {
                case 1:
                    criarConta(cliente, TipoConta.CONTA_CORRENTE, TipoCliente.PESSOA_FISICA, endereco);
                    break;
                case 2:
                    criarConta(cliente, TipoConta.CONTA_POUPANCA, TipoCliente.PESSOA_FISICA, endereco);
                    break;
                case 3:
                    criarConta(cliente, TipoConta.CONTA_INVESTIMENTO, TipoCliente.PESSOA_FISICA, endereco);
                    break;
                case 4:
                    pessoaView.painelPessoa();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    painelContasPF(cliente, endereco);
                    break;
            }
        } else {
            System.out.println("Opção Inválida");
            painelContasPF(cliente, endereco);
        }


    }

    public void criarConta(Cliente cliente, TipoConta tipoConta, TipoCliente tipoCliente, Endereco endereco) {
        Scanner input = new Scanner(System.in);

        var agencia = agenciaView.painelAgencia();

        System.out.println("Digite sua senha, máximo de 6 digitos: ");
        int senha = input.nextInt();

        var criarConta = new Conta(cliente, tipoConta, agencia, senha, tipoCliente, endereco);
        contaController.criarConta(criarConta);
        menu.painelInicio();
    }

}
