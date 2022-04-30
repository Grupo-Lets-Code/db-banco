package br.com.letscode.dbbanco.entities;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class Utils {

    /*private final Menu chamar;

    public Utils(@Lazy Menu chamar) {
        this.chamar = chamar;
    }*/

    public LocalDate formatarData(String data) {
        String[] fields = data.split("/");
        return LocalDate.of(
                Integer.parseInt(fields[2]),
                Integer.parseInt(fields[1]),
                Integer.parseInt(fields[0])
        );
    }

    public BigDecimal FormatValor (BigDecimal valor){
        return valor.setScale(2, RoundingMode.HALF_EVEN);
    }

    /*public void outraOperacao() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDeseja realizar outra operação? Escreva: sim ou nao");
        String validacao = input.nextLine();
        if(validacao.equals("sim")) {
            chamar.painelInicio();
        } else {
            System.out.println("Obrigado por utilizar o Banco Grupo Azul!");
            System.exit(0);
        }
    }*/

}
