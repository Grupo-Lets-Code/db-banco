package br.com.letscode.dbbanco.view.agencia;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AgenciaView {

    public int painelAgencia() {
        Scanner input = new Scanner(System.in);
        System.out.println("Escolha sua agência:");
        System.out.println("Agência: 101 - Agência Sul");
        System.out.println("Agência: 202 - Agência Sudeste");
        System.out.println("Agência: 303 - Agência Centro-Oeste");
        System.out.println("Agência: 404 - Agência Nordeste");
        System.out.println("Agência: 505 - Agência Norte");

        int operacao = input.nextInt();
        switch (operacao) {
            case 101:
            case 202:
            case 303:
            case 404:
            case 505:
                return operacao;
            default:
                System.out.println("Agência Inválida!");
                painelAgencia();
        }
        return input.nextInt();
    }
}
