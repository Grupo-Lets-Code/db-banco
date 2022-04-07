package br.com.letscode.dbbanco.view;

import br.com.letscode.dbbanco.controller.ClienteController;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class Menu {

    static Scanner input = new Scanner(System.in);

    private final ClienteController clienteController;

    public Menu(ClienteController clienteController) {
        this.clienteController = clienteController;
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
        System.out.println("|    Opção 7 - Sair                |");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                painelPessoa();
                break;
            case 2:
                painelSacar();
                break;
            case 3:
                painelDepositar();
                break;
            case 4:
                painelTransferir();
                break;
            case 5:
                painelInvestir();
                break;
            case 6:
                painelSaldo();
                break;
            case 7:
                System.out.println("Obrigado por utilizar o Banco Grupo Azul!");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
                painelInicio();
                break;
        }
    }

    protected void painelPessoa() {
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
                painelInicio();
                break;
            default:
                System.out.println("Opção inválida!");
                painelPessoa();
                break;
        }
    }

    protected void tipoPF() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite seu nome: ");
        String nome = input.nextLine();

        System.out.println("\nDigite seu email: ");
        String email = input.nextLine();

        System.out.println("\nDigite seu telefone: ");
        String telefone = input.nextLine();

        System.out.println("\nDigite seu CPF: ");
        String cpf = input.nextLine();

        System.out.println("\nDigite sua data de nascimento: ");
        String data_nascimento = input.nextLine();

        clienteController.createPF(nome, email, telefone, cpf, data_nascimento);
        painelContasPF();
    }

    protected void tipoPJ() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite sua razão social: ");
        String nome = input.nextLine();

        System.out.println("\nDigite seu email corporativo: ");
        String email = input.nextLine();

        System.out.println("\nDigite seu telefone: ");
        String telefone = input.nextLine();

        System.out.println("\nDigite seu CNPJ: ");
        String cnpj = input.nextLine();

        System.out.println("\nDigite a data de abertura da empresa: ");
        String data_abertura = input.nextLine();

        clienteController.createPJ(nome, email, telefone, cnpj, data_abertura);
        painelContasPJ();
    }

    protected void painelContasPF() {
        System.out.println("|    Opção 1 - Conta Corrente           |");
        System.out.println("|    Opção 2 - Conta Poupança           |");
        System.out.println("|    Opção 3 - Conta Investimento       |");
        System.out.println("|    Opção 4 - Voltar                   |");

        int tipoConta = input.nextInt();

        switch (tipoConta) {
            case 1:
                //Chamar o metodo abrir conta corrente
                break;
            case 2:
                //Chamar o metodo abrir conta poupança
                break;
            case 3:
                //Chamar o metodo abrir conta investimento
                break;
            case 4:
                painelPessoa();
                break;
            default:
                System.out.println("Opção inválida!");
                painelContasPF();
                break;
        }
    }

    protected void painelContasPJ() {
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
                painelPessoa();
                break;
            default:
                System.out.println("Opção inválida!");
                tipoPJ();
                break;
        }
    }

    protected void painelSacar() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da conta: ");
        String numeroConta = input.nextLine();

        //FIXME Validar se a conta existe antes de passar para a senha
        //Exemplo: contaExists(); para verificar se a conta existe

        //FIXME SE CONTA NÃO EXISTE:
        System.out.println("\nConta inválida!");
        painelSacar();

        //FIXME SE CONTA EXISTE:
        System.out.println("\nDigite a senha da conta: ");
        String senha = input.nextLine();

        //FIXME SE SENHA CORRETA, então
        System.out.println("\nDigite o valor do saque: ");
        BigDecimal valor = input.nextBigDecimal();

        //FIXME SE SENHA INCORRETA, então
        System.out.println("\nSenha inválida!");
        painelSacar();

        //FIXME SE SALDO POSITIVO, então
        System.out.println("\nSaque no valor de " + valor + "R$ realizado com sucesso! Saldo atual: " /*saldo*/);

        //FIXME SE NÃO:
        System.out.println("\nSaldo insuficiente para realizar essa transação! Saldo atual: " /*saldo*/);
    }

    protected void painelDepositar() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da conta que deseja realizar o depósito: ");
        String numeroConta = input.nextLine();

        //FIXME Validar se a conta existe
        //Exemplo: contaExists(); para verificar se a conta existe

        //FIXME SE CONTA NÃO EXISTE:
        System.out.println("\nConta inválida!");
        painelDepositar();

        //FIXME SE CONTA EXISTE:
        System.out.println("\nDigite o valor do depósito: ");
        BigDecimal valor = input.nextBigDecimal();
        System.out.println("\nDepósito no valor de " + valor + "R$ realizado com sucesso! Saldo atual: " /*saldo*/);
    }

    protected void painelInvestir() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da conta: ");
        String numeroConta = input.nextLine();

        //FIXME Validar se a conta existe antes de passar para a senha
        //Exemplo: contaExists(); para verificar se a conta existe

        //FIXME SE CONTA NÃO EXISTE:
        System.out.println("\nConta inválida!");
        painelInvestir();

        //FIXME SE CONTA EXISTE:
        System.out.println("\nDigite a senha da conta: ");
        String senha = input.nextLine();

        //FIXME SE SENHA CORRETA, então
        System.out.println("\nDigite o valor do investimento: ");
        BigDecimal valor = input.nextBigDecimal();
        System.out.println("\nInvestimento no valor de " + valor + "R$ realizado com sucesso! Saldo atual: " /*saldo*/);

        //FIXME SE SENHA INCORRETA, então
        System.out.println("\nSenha inválida!");
        painelInvestir();
    }

    protected void painelTransferir() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da sua conta: ");
        String contaRemetente = input.nextLine();

        System.out.println("\nDigite o número da conta que deseja enviar a transferência: ");
        String contaDestinataria = input.nextLine();

        //FIXME Validar se as contas existem antes de passar para a senha
        //Exemplo: contaExists(); para verificar se as contas existem

        //FIXME SE CONTA REMETENTE NÃO EXISTE:
        System.out.println("\nConta remetente inválida!");
        painelTransferir();

        //FIXME SE CONTA DESTINATARIA NÃO EXISTE:
        System.out.println("\nConta destinatária inválida!");
        painelTransferir();

        //FIXME SE AS CONTAS EXISTEM:
        System.out.println("\nDigite a senha da sua conta: ");
        String senha = input.nextLine();

        //FIXME SE SENHA CORRETA, então
        System.out.println("\nDigite o valor da transferência: ");
        BigDecimal valor = input.nextBigDecimal();
        System.out.println("\nTransferência no valor de " + valor + "R$ realizada com sucesso! Saldo atual: " /*saldo*/);

        //FIXME SE SENHA INCORRETA, então
        System.out.println("\nSenha inválida!");
        painelTransferir();
    }

    protected void painelSaldo() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da conta: ");
        String numeroConta = input.nextLine();

        //FIXME Validar se a conta existe antes de passar para a senha
        //Exemplo: contaExists(); para verificar se a conta existe

        //FIXME SE CONTA NÃO EXISTE:
        System.out.println("\nConta inválida!");
        painelSaldo();

        //FIXME SE CONTA EXISTE:
        System.out.println("\nDigite a senha da conta: ");
        String senha = input.nextLine();

        //FIXME SE SENHA CORRETA, então
        //MOSTRAR OS DADOS DA CONTA

        //FIXME SE SENHA INCORRETA, então
        System.out.println("\nSenha inválida!");
        painelSaldo();
    }
}
