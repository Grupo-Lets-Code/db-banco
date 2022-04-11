package br.com.letscode.dbbanco.view;

import br.com.letscode.dbbanco.view.conta.OperacoesView;
import br.com.letscode.dbbanco.view.endereco.EnderecoView;
import br.com.letscode.dbbanco.view.pessoa.PessoaView;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Lazy
public class Menu {
    static Scanner input = new Scanner(System.in);

    private final PessoaView pessoaView;
    private final OperacoesView operacoesView;
    private final EnderecoView enderecoView;

    public Menu(PessoaView pessoaView, OperacoesView operacoesView, EnderecoView enderecoView) {
        this.pessoaView = pessoaView;
        this.operacoesView = operacoesView;
        this.enderecoView = enderecoView;
    }

    public void painelInicio() {
        System.out.println(" ----------------------------------------------------- ");
        System.out.println("|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ Bem-vindo ao⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀|");
        System.out.println("|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀$⠀Banco Grupo Azul⠀$⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀|");
        System.out.println("|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ |");
        System.out.println("|⠀⠀⠀⠀⠀⠀Selecione a operação que deseja realizar⠀⠀⠀⠀⠀⠀⠀ |");
        System.out.println(" ----------------------------------------------------- ");
        System.out.println("|    Opção 1 - Abrir conta         |");
        System.out.println("|    Opção 2 - Sacar               |");
        System.out.println("|    Opção 3 - Depositar           |");
        System.out.println("|    Opção 4 - Transferir          |");
        System.out.println("|    Opção 5 - Investir            |");
        System.out.println("|    Opção 6 - Consultar saldo     |");
        System.out.println("|    Opção 7 - Listar conta        |");
        System.out.println("|    Opção 8 - Excluir contas      |");
        System.out.println("|    Opção 9 - Alterar endereço    |");
        System.out.println("|    Opção 10 - Sair               |");

        String validador = input.nextLine();
        int operacao = 0;

        try{
            operacao = Integer.parseInt(validador);
            switch (operacao){
                case 1:
                    pessoaView.painelPessoa();
                    break;
                case 2:
                    operacoesView.painelSacar();
                    break;
                case 3:
                    operacoesView.painelDepositar();
                    break;
                case 4:
                    operacoesView.painelTransferir();
                    break;
                case 5:
                    operacoesView.painelInvestir();
                    break;
                case 6:
                    operacoesView.painelSaldo();
                    break;
                case 7:
                    operacoesView.painelListar();
                    break;
                case 8:
                    operacoesView.painelExcluir();
                    break;
                case 9:
                    enderecoView.painelAlterarEndereco();
                    break;
                case 10:
                    System.out.println("Obrigado por utilizar o Banco Grupo Azul!");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
                    painelInicio();
                    break;
            }
        } catch (Exception e){
            System.out.println("Opção Inválida\n");
            painelInicio();
        }
    }
}