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

        String validador = input.nextLine();
        int tipoPessoa = 0;

        try{
            tipoPessoa = Integer.parseInt(validador);
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
        } catch (Exception e){
            System.out.println("Opção Inválida\n");
            painelPessoa();
        }
    }

    public void tipoPF() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite seu nome: ");
        String nome = input.nextLine();

        System.out.println("\nDigite seu email. Ex: email.exemplo@gmail.com: ");
        String email = input.nextLine();

        System.out.println("\nDigite seu telefone, somente números. Ex:12999999999: ");
        String telefone = input.nextLine();

        System.out.println("\nDigite seu CPF, somente números. Ex: 12345678910: ");
        String cpf = input.nextLine();

        System.out.println("\nDigite sua data de nascimento, com barras. Ex: 01/01/2001: ");
        String dataNascimento = input.nextLine();

        if (email.matches("\\S{1,100}@[a-z]{1,7}(?:.com)") &&
                cpf.matches("\\d{11}") &&
                telefone.matches("\\d{9,13}") &&
                dataNascimento.matches("\\d{2}\\/\\d{2}\\/\\d{4}")){
            var cliente = clienteController.createPF(nome, email, telefone, cpf, utilities.formatarData(dataNascimento));
            enderecoView.mapearEndereco(cliente, TipoCliente.PESSOA_FISICA);
        } else {
            System.out.println("Dados Inválidos! Digite novamente");
            tipoPF();
        }


    }

    public void tipoPJ() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite sua razão social: ");
        String nome = input.nextLine();

        System.out.println("\nDigite seu email corporativo. Ex: email.exemplo@gmail.com: ");
        String email = input.nextLine();

        System.out.println("\nDigite seu telefone, somente números. Ex:12999999999: ");
        String telefone = input.nextLine();

        System.out.println("\nDigite seu CNPJ, somente números. Ex: 12345678000112 ou 12345678000212: ");
        String cnpj = input.nextLine();

        while (cnpj.length() != 14) {
            System.out.println("Formato Inválido");
            System.out.println("\nDigite seu CNPJ, somente números. Ex: 12345678000112 ou 12345678000212:: ");
            cnpj = input.nextLine();
        }

        System.out.println("\nDigite a data de abertura da empresa, com barras. Ex: 01/01/2001: ");
        String dataAbertura = input.nextLine();

        if (email.matches("\\S{1,100}@[a-z]{1,7}(?:.com)") &&
                cnpj.matches("\\d{8}(?:000[1-2])\\d{2}") &&
                telefone.matches("\\d{9,13}") &&
                dataAbertura.matches("\\d{2}\\/\\d{2}\\/\\d{4}")){
            var cliente = clienteController.createPJ(nome, email, telefone, cnpj, utilities.formatarData(dataAbertura));
            enderecoView.mapearEndereco(cliente, TipoCliente.PESSOA_JURIDICA);
        } else {
            System.out.println("Dados Inválidos! Digite novamente");
            tipoPJ();
        }
    }
}
