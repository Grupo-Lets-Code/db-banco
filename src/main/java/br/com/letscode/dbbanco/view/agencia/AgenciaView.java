package br.com.letscode.dbbanco.view.agencia;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AgenciaView {

    public int painelAgencia() {
        Scanner input = new Scanner(System.in);
        System.out.println("Escolha suas agencias:");
        System.out.println("Agencia: 101 - Agencia Sul");
        System.out.println("Agencia: 202 - Agencia Sudeste");
        System.out.println("Agencia: 303 - Agencia Centro-Oeste");
        System.out.println("Agencia: 404 - Agencia Nordeste");
        System.out.println("Agencia: 505 - Agencia Norte");
        return input.nextInt();
    }
}
