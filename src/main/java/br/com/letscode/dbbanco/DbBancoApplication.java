package br.com.letscode.dbbanco;

import br.com.letscode.dbbanco.controller.ContaController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Slf4j
@Configuration
public class DbBancoApplication implements CommandLineRunner {
    public static void main(String[] args) {
        try{
            // NOTE: Retire o .close() para manter a aplicação rodando
            SpringApplication.run(DbBancoApplication.class, args).close();
        } catch (Exception e){
            System.out.println("Erro");
        }
    }

    @Override
    public void run(String... args) throws Exception {
        // Teste da validação pelo Bean Annotation
        System.out.println("Carlos");
    }
}
