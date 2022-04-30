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

    @Override
    public void run(String... args) throws Exception {

        // Teste da validação pelo Beans Annotation
        Cliente clienteOK = new Cliente("Carlos Masao Mito", "carlosmsmito@gmail.com", "99999999999");
        Cliente clienteSemEmail = new Cliente("Carlos Masao Mito", "", "99999999999");
        Cliente clienteSemNome = new Cliente("", "carlosmsmito@gmail.com", "99999999999");
        Cliente clienteEmailErrado1 = new Cliente("Carlos Masao Mito", "abc245@", "1111111111");
        Cliente clienteEmailErrado2 = new Cliente("Carlos Masao Mito", "abc245", "9999999999");
        Cliente clienteEmailErrado3 = new Cliente("Carlos Masao Mito", "abc245@af@asd", "9999999999");
        Cliente clienteTelefoneErrado = new Cliente("Carlos Masao Mito", "carlosmsmito@gmail.com", "123456");

        List<Cliente> clientes = Arrays.asList(
                clienteOK,
                clienteSemEmail,
                clienteSemNome,
                clienteEmailErrado1,
                clienteEmailErrado2,
                clienteEmailErrado3,
                clienteTelefoneErrado
        );

        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = factory.getValidator();
            clientes.forEach(cliente -> System.out.println(validator.validate(cliente)));
        }
    }
}
