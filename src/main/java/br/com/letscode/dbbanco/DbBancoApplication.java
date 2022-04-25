package br.com.letscode.dbbanco;

import br.com.letscode.dbbanco.controller.ContaController;
import br.com.letscode.dbbanco.view.Menu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DbBancoApplication implements CommandLineRunner{

    private final Menu chamarMenu;

    public DbBancoApplication(Menu criarMenu) {
        this.chamarMenu = criarMenu;
    }

    public static void main(String[] args) {
        try{
            SpringApplication.run(DbBancoApplication.class, args);
        } catch (Exception e){
            System.out.println("Erro");
        }

    }

    @Override
    public void run(String... args) throws Exception{
        chamarMenu.painelInicio();
    }
}
