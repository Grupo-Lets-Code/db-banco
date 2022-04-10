package br.com.letscode.dbbanco.view.pessoa;

import br.com.letscode.dbbanco.controller.ClienteController;
import br.com.letscode.dbbanco.entities.Endereco;
import br.com.letscode.dbbanco.entities.Utils;
import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.cliente.TipoCliente;
import br.com.letscode.dbbanco.entities.conta.TipoConta;
import br.com.letscode.dbbanco.view.Menu;
import br.com.letscode.dbbanco.view.conta.ContaView;
import br.com.letscode.dbbanco.view.endereco.EnderecoView;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Lazy
public class PessoaView {
    static Scanner input = new Scanner(System.in);

    private final Menu menu;
    private final Utils utilities;
    private final ClienteController clienteController;
    private final EnderecoView enderecoView;
    private final ContaView contaView;

    public PessoaView(Menu menu, EnderecoView enderecoView, ContaView contaView,
                      Utils utilities, ClienteController clienteController) {
        this.menu = menu;
        this.enderecoView = enderecoView;
        this.contaView = contaView;
        this.utilities = utilities;
        this.clienteController = clienteController;
    }

    public void painelPessoa() {
        System.out.println("|    Opção 1 - Pessoa Física      |");
        System.out.println("|    Opção 2 - Pessoa Jurídica    |");
        System.out.println("|    Opção 3 - Voltar             |");

        int tipoPessoa = input.nextInt();

        switch (tipoPessoa) {
            case 1:
                tipoPF();
                break;
            case 2:
                tipoPJ();
                break;
            case 3:
                menu.painelInicio();
                break;
            default:
                System.out.println("Opção inválida!");
                painelPessoa();
                break;
        }
    }

    public void tipoPF() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite seu nome: ");
        String nome = input.nextLine();

        System.out.println("\nDigite seu email: ");
        String email = input.nextLine();

        System.out.println("\nDigite seu telefone: ");
        String telefone = input.nextLine();

        System.out.println("\nDigite seu CPF, somente números: ");
        String cpf = input.nextLine();

        while (cpf.length() != 11) {
            System.out.println("Formato Inválido");
            System.out.println("\nDigite seu CPF, somente números: ");
            cpf = input.nextLine();
        }

        System.out.println("\nDigite sua data de nascimento, com barras: ");
        String dataNascimento = input.nextLine();

        var cliente = clienteController.createPF(nome, email, telefone, cpf, utilities.formatarData(dataNascimento));
        enderecoView.mapearEndereco(cliente, TipoCliente.PESSOA_FISICA);
    }

    public void tipoPJ() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite sua razão social: ");
        String nome = input.nextLine();

        System.out.println("\nDigite seu email corporativo: ");
        String email = input.nextLine();

        System.out.println("\nDigite seu telefone: ");
        String telefone = input.nextLine();

        System.out.println("\nDigite seu CNPJ, somente números: ");
        String cnpj = input.nextLine();

        while (cnpj.length() != 14) {
            System.out.println("Formato Inválido");
            System.out.println("\nDigite seu CNPJ, somente números: ");
            cnpj = input.nextLine();
        }

        System.out.println("\nDigite a data de abertura da empresa, com barras: ");
        String dataAbertura = input.nextLine();

        var cliente = clienteController.createPJ(nome, email, telefone, cnpj, utilities.formatarData(dataAbertura));
        enderecoView.mapearEndereco(cliente, TipoCliente.PESSOA_JURIDICA);
    }

    public void painelContasPF(Cliente cliente, Endereco endereco) {
        System.out.println("|    Opção 1 - Conta Corrente           |");
        System.out.println("|    Opção 2 - Conta Poupança           |");
        System.out.println("|    Opção 3 - Conta Investimento       |");
        System.out.println("|    Opção 4 - Voltar                   |");

        int tipoConta = input.nextInt();

        switch (tipoConta) {
            case 1:
                contaView.criarConta(cliente, TipoConta.CONTA_CORRENTE, TipoCliente.PESSOA_FISICA, endereco);
                break;
            case 2:
                contaView.criarConta(cliente, TipoConta.CONTA_POUPANCA, TipoCliente.PESSOA_FISICA, endereco);
                break;
            case 3:
                contaView.criarConta(cliente, TipoConta.CONTA_INVESTIMENTO, TipoCliente.PESSOA_FISICA, endereco);
                break;
            case 4:
                painelPessoa();
                break;
            default:
                System.out.println("Opção inválida!");
                painelContasPF(cliente, endereco);
                break;
        }
    }
}
