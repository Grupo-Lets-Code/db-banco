package br.com.letscode.dbbanco;

import br.com.letscode.dbbanco.controller.ContaController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Slf4j
@Configuration
public class DbBancoApplication{
    public static void main(String[] args) {
        try{
            SpringApplication.run(DbBancoApplication.class, args);
        } catch (Exception e){
            System.out.println("Erro");
        }

    }
}
