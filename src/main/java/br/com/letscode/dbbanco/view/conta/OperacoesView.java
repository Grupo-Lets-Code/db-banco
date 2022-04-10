package br.com.letscode.dbbanco.view.conta;

import br.com.letscode.dbbanco.controller.ContaController;
import br.com.letscode.dbbanco.view.Menu;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class OperacoesView {

    private final Menu menu;
    private final ContaController contaController;

    public OperacoesView(@Lazy Menu menu, ContaController contaController) {
        this.menu = menu;
        this.contaController = contaController;
    }

    public void painelSacar() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da conta: ");
        Integer numeroConta = Integer.valueOf(input.next());

        System.out.println("\nDigite a senha da conta: ");
        int senha = input.nextInt();

        System.out.println("\nDigite o valor do saque: ");
        BigDecimal valor = input.nextBigDecimal();

        var verifica = contaController.sacar(numeroConta, senha, valor);
        if (verifica) {
            menu.painelInicio();
        } else {
            painelSacar();
        }
    }

    public void painelDepositar() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da conta que deseja realizar o depósito: ");
        Integer numeroConta = Integer.valueOf(input.next());

        var verificaConta = contaController.validarConta(numeroConta);
        if (verificaConta) {
            System.out.println("\nDigite o valor do depósito: ");
            BigDecimal valor = input.nextBigDecimal();
            contaController.depositar(numeroConta, valor);
            menu.painelInicio();
        } else {
            System.out.println("\nConta não encontrada!");
            painelDepositar();
        }
    }

    public void painelInvestir() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da conta: ");
        Integer numeroConta = Integer.valueOf(input.next());

        System.out.println("\nDigite o valor do investimento: ");
        BigDecimal valor = input.nextBigDecimal();

        var verifica = contaController.investir(numeroConta, valor);
        if(verifica){
            menu.painelInicio();
        } else{
            menu.painelInicio();
        }
    }

    public void painelTransferir() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da sua conta: ");
        Integer contaRemetente = Integer.valueOf(input.next());

        System.out.println("\nDigite o número da conta que deseja enviar a transferência: ");
        Integer contaDestinataria = Integer.valueOf(input.next());

        System.out.println("\nDigite a senha da sua conta: ");
        int senha = input.nextInt();

        System.out.println("\nDigite o valor da transferência: ");
        BigDecimal valor = input.nextBigDecimal();

        var verifica = contaController.transferir(contaRemetente, contaDestinataria, senha, valor);
        if (verifica){
            menu.painelInicio();
        } else{
            painelTransferir();
        }
    }

    public void painelSaldo() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da conta: ");
        Integer numeroConta = Integer.valueOf(input.next());

        System.out.println("\nDigite a senha da conta: ");
        int senha = input.nextInt();

        var verifica = contaController.consultarSaldo(numeroConta, senha);
        if(verifica)
            menu.painelInicio();
        else painelSaldo();
    }

    public void painelListar() {
        var allContas = contaController.listarContas();
        System.out.println("Lista de Contas");
        allContas.forEach(System.out::println);
        menu.painelInicio();
    }

    public void painelExcluir() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da conta: ");
        Integer numeroConta = Integer.valueOf(input.next());

        System.out.println("\nDigite a senha da conta: ");
        int senha = input.nextInt();

        var verifica = contaController.validarLogin(numeroConta, senha);
        input.nextLine();
        if(verifica){
            System.out.println("\nDeseja realmente EXCLUIR sua conta? Escreva: sim ou nao");
            String validacao = input.nextLine();
            if(validacao.equals("sim")) {
                contaController.excluirConta(numeroConta);
                menu.painelInicio();
            } else {
                painelExcluir();
            }
        } else {
            System.out.println("\nDados inválidos!");
            menu.painelInicio();
        }
    }
}
