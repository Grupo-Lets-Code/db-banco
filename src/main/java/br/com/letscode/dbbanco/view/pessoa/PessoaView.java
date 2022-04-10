package br.com.letscode.dbbanco.view.pessoa;

import br.com.letscode.dbbanco.controller.ClienteController;
import br.com.letscode.dbbanco.entities.Utils;
import br.com.letscode.dbbanco.entities.cliente.TipoCliente;
import br.com.letscode.dbbanco.view.Menu;
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

    public PessoaView(@Lazy Menu menu, EnderecoView enderecoView,
                      Utils utilities, ClienteController clienteController) {
        this.menu = menu;
        this.enderecoView = enderecoView;
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
}
