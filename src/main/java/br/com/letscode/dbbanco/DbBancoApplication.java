package br.com.letscode.dbbanco;

import br.com.letscode.dbbanco.controller.ContaController;
import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.cliente.ClientePF;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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

    public static void testeValidacaoCliente() {

        // Teste da validação pelo Beans Annotation

        List<Cliente> clientes = Arrays.asList(
                new Cliente("Carlos Masao Mito", "carlosmsmito@gmail.com", "99999999999"),
                new Cliente("Carlos Masao Mito", "", "99999999999"),
                new Cliente("", "carlosmsmito@gmail.com", "99999999999"),
                new Cliente("Carlos Masao Mito", "abc245@", "1111111111"),
                new Cliente("Carlos Masao Mito", "abc245", "9999999999"),
                new Cliente("Carlos Masao Mito", "abc245@af@asd", "9999999999"),
                new Cliente("Carlos Masao Mito", "carlosmsmito@gmail.com", "123456")
        );

        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = factory.getValidator();
            clientes.forEach(cliente -> System.out.println(validator.validate(cliente)));
        }

    }

    public static void testeValidacaoClientePF() {
        Cliente clienteTest = new Cliente("Carlos Masao Mito", "carlosmsmito@gmail.com", "99999999999");

        // Teste da validação pelo Beans Annotation

        List<ClientePF> clientes = Arrays.asList(
                new ClientePF("19374832923", LocalDate.now(), clienteTest),
                new ClientePF("19374832923", null, clienteTest),
                new ClientePF("19374832923", LocalDate.now(), null),
                new ClientePF("123456", LocalDate.now(), clienteTest),
                new ClientePF("5325135325235626", LocalDate.now(), clienteTest)
        );

        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = factory.getValidator();
            clientes.forEach(cliente -> System.out.println(validator.validate(cliente)));
        }

    }

    @Override
    public void run(String... args) throws Exception {
        DbBancoApplication.testeValidacaoClientePF();
    }
}
