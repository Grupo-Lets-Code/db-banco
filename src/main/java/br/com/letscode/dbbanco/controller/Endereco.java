package br.com.letscode.dbbanco.controller;
import java.util.Scanner;

public class Endereco {





    public static void MapearEndereco(){
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o logradouro:");
            String lagradouro = input.next();
        System.out.println("Digite o numero:");
            String numero = input.next();
        System.out.println("Digite a cidade:");
            String cidade = input.nextLine();
        System.out.println("Digite o bairro:");
            String bairro = input.nextLine();
        System.out.println("Digite o estado:");
            String estado = input.nextLine();
        System.out.println("Digite o pais:");
            String pais = input.nextLine();
        System.out.println("Digite o cep (Só os números):");
            int cep = input.nextInt();




    }

}
