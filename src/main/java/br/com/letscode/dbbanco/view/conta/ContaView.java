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
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ContaView {

    private final Menu menu;
    private final PessoaView pessoaView;
    private final AgenciaView agenciaView;
    private final ContaController contaController;

    public ContaView(Menu menu, PessoaView pessoaView, ContaController contaController,
                     AgenciaView agenciaView) {
        this.menu = menu;
        this.pessoaView = pessoaView;
        this.contaController = contaController;
        this.agenciaView = agenciaView;
    }

    public void painelContasPJ(Cliente cliente, Endereco endereco) {
        Scanner input = new Scanner(System.in);

        System.out.println("|    Opção 1 - Conta Corrente           |");
        System.out.println("|    Opção 2 - Conta Investimento       |");
        System.out.println("|    Opção 3 - Voltar                   |");

        int tipoContaPJ = input.nextInt();

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
                System.out.println("Opção inválida!");
                painelContasPJ(cliente, endereco);
                break;
        }
    }

    public void painelContasPF(Cliente cliente, Endereco endereco) {
        Scanner input = new Scanner(System.in);
        System.out.println("|    Opção 1 - Conta Corrente           |");
        System.out.println("|    Opção 2 - Conta Poupança           |");
        System.out.println("|    Opção 3 - Conta Investimento       |");
        System.out.println("|    Opção 4 - Voltar                   |");

        int tipoConta = input.nextInt();

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
    }

    public void criarConta(Cliente cliente, TipoConta tipoConta, TipoCliente tipoCliente, Endereco endereco) {
        Scanner input = new Scanner(System.in);
        var agencia =  agenciaView.painelAgencia();

        System.out.println("Digite sua senha");
        var senha = input.nextInt();

        var criarConta = new Conta(cliente, tipoConta, agencia, senha, tipoCliente, endereco);
        contaController.criarConta(criarConta);
        menu.painelInicio();
    }

}
