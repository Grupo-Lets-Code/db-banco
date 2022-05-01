package br.com.letscode.dbbanco;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Slf4j
@Configuration
public class DbBancoApplication{
    private static final Logger LOGGER = LoggerFactory.getLogger(DbBancoApplication.class);
    public static void main(String[] args) {
        try{
            LOGGER.info("\n ===>>> Iniciando Aplicação Banco Grupo Azul <<<===");
            SpringApplication.run(DbBancoApplication.class, args);
            LOGGER.info("\n=============================================================== \n" +
                    "                 Banco Grupo Azul\n" +
                    "===============================================================");
        } catch (Exception e){
            LOGGER.error("Erro ao iniciar a Aplicação", e);
        }

    }
}
