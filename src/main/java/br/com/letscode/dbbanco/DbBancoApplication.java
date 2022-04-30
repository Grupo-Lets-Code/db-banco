package br.com.letscode.dbbanco;

import br.com.letscode.dbbanco.controller.ContaController;
import br.com.letscode.dbbanco.entities.cliente.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@SpringBootApplication
@Slf4j
@Configuration
public class DbBancoApplication implements CommandLineRunner {
    public static void main(String[] args) {
        try{
            // NOTE: Retire o .close() para manter a aplicação rodando
            SpringApplication.run(DbBancoApplication.class, args).close();
        } catch (Exception e) {
            System.out.println("Erro");
        }
    }

    @Override
    public void run(String... args) throws Exception {
        // Teste da validação pelo Beans Annotation
        @Valid Cliente clienteOK = new Cliente("Carlos Masao Mito", "carlosmsmito@gmail.com", "(99) 99999-9999");
        @Valid Cliente clienteSemNome = new Cliente("", "carlosmsmito@gmail.com", "(99) 99999-9999");
        @Valid Cliente clienteEmailErrado1 = new Cliente("Carlos Masao Mito", "abc245@", "(99) 99999-9999");
        @Valid Cliente clienteEmailErrado2 = new Cliente("Carlos Masao Mito", "abc245", "(99) 99999-9999");
        @Valid Cliente clienteEmailErrado3 = new Cliente("Carlos Masao Mito", "abc245@af@asd", "(99) 99999-9999");
        @Valid Cliente clienteTelefoneErrado = new Cliente("Carlos Masao Mito", "carlosmsmito@gmail.com", "123456");
        @Valid Cliente clienteTelefoneDesformatado = new Cliente("Carlos Masao Mito", "", "99999999999");

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        var violations1 = validator.validate(clienteOK);
        var violations2 = validator.validate(clienteSemNome);

        System.out.println(violations1);
        System.out.println(violations2);
    }
}
