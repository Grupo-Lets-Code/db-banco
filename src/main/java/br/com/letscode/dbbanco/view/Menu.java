package br.com.letscode.dbbanco.view;

import java.util.Scanner;

public class Menu {

    static Scanner input = new Scanner(System.in);

    public static void menu() {
        System.out.println(" ----------------------------------------------------- ");
        System.out.println("|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ Welcome to⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ |");
        System.out.println("|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀$⠀Let's Code Bank⠀$⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀|");
        System.out.println("|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀|");
        System.out.println("|⠀⠀⠀⠀⠀⠀Selecione a operação que deseja realizar⠀⠀⠀⠀⠀⠀⠀|");
        System.out.println(" ----------------------------------------------------- ");
        System.out.println("|    Opção 1 - Abrir conta       |");
        System.out.println("|    Opção 2 - Sacar             |");
        System.out.println("|    Opção 3 - Depositar         |");
        System.out.println("|    Opção 4 - Transferir        |");
        System.out.println("|    Opção 5 - Investir          |");
        System.out.println("|    Opção 6 - Consultar contas  |");
        System.out.println("|    Opção 7 - Sair              |");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                painelConta();
                break;
            case 2:
                painelSaque();
                break;
            case 3:
                //Conta.depositar();
                break;
            case 4:
                painelTransferir();
                break;
            case 5:
                painelInvestir();
                break;
            case 6:
                //Banco.consultarContas();
                break;
            case 7:
                System.out.println("Obrigador por utilizar o Let's Code Bank!");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
                menu();
                break;
        }

    }

    public static void painelSaque() {
        System.out.println("|    Opção 1 - Saque Pessoa Fisíca      |");
        System.out.println("|    Opção 2 - Saque Pessoa Jurídica    |");
        System.out.println("|    Opção 3 - Voltar                   |");

        int tipoContaSaque = input.nextInt();

        switch (tipoContaSaque) {
            case 1:
                //Conta.sacar();
                break;
            case 2:
                //Conta.sacarPJ();
                break;
            case 3:
                menu();
                break;
            default:
                System.out.println("Opção inválida!");
                painelSaque();
                break;
        }
    }

    public static void painelInvestir() {
        System.out.println("|    Opção 1 - Investimento Pessoa Fisíca      |");
        System.out.println("|    Opção 2 - Investimento Pessoa Jurídica    |");
        System.out.println("|    Opção 3 - Voltar                          |");

        int tipoContaInvestimento = input.nextInt();

        switch (tipoContaInvestimento) {
            case 1:
                //Conta.investir();
                break;
            case 2:
                //Conta.investirPJ();
                break;
            case 3:
                menu();
                break;
            default:
                System.out.println("Opção inválida!");
                painelInvestir();
                break;
        }
    }

    public static void painelTransferir() {
        System.out.println("|    Opção 1 - Transferência Pessoa Fisíca      |");
        System.out.println("|    Opção 2 - Transferência Pessoa Jurídica    |");
        System.out.println("|    Opção 3 - Voltar                           |");

        int tipoContaTransferir = input.nextInt();

        switch (tipoContaTransferir) {
            case 1:
                //Conta.transferir();
                break;
            case 2:
                //Conta.transferirPJ();
                break;
            case 3:
                menu();
                break;
            default:
                System.out.println("Opção inválida!");
                painelTransferir();
                break;
        }
    }

    public static void painelConta() {
        System.out.println("|    Opção 1 - Pessoa Fisíca      |");
        System.out.println("|    Opção 2 - Pessoa Jurídica    |");
        System.out.println("|    Opção 3 - Voltar             |");

        int tipoConta = input.nextInt();

        switch (tipoConta) {
            case 1:
                tipoPF();
                break;
            case 2:
                tipoPJ();
                break;
            case 3:
                menu();
                break;
            default:
                System.out.println("Opção inválida!");
                painelConta();
                break;
        }
    }

    public static void tipoPF() {
        System.out.println("|    Opção 1 - Conta Corrente           |");
        System.out.println("|    Opção 2 - Conta Poupança           |");
        System.out.println("|    Opção 3 - Conta Investimento       |");
        System.out.println("|    Opção 4 - Voltar                   |");

        int tipoContaPF = input.nextInt();

        switch (tipoContaPF) {
            case 1:
                //Banco.criarCorrentePF();
                break;
            case 2:
                //Banco.criarPoupancaPF();
                break;
            case 3:
                //Banco.criarInvestimentoPF();
                break;
            case 4:
                painelConta();
                break;
            default:
                System.out.println("Opção inválida!");
                tipoPF();
                break;
        }
    }

    public static void tipoPJ() {
        System.out.println("|    Opção 1 - Conta Corrente           |");
        System.out.println("|    Opção 2 - Conta Investimento       |");
        System.out.println("|    Opção 3 - Voltar                   |");

        int tipoContaPJ = input.nextInt();

        switch (tipoContaPJ) {
            case 1:
                //Banco.criarCorrentePJ();
                break;
            case 2:
                //Banco.criarInvestimentoPJ();
                break;
            case 3:
                painelConta();
                break;
            default:
                System.out.println("Opção inválida!");
                tipoPJ();
                break;
        }
    }

}
