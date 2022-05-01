package br.com.letscode.dbbanco;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Slf4j
@Configuration
public class DbBancoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DbBancoApplication.class, args);
    }
}
