package br.com.letscode.dbbanco;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import lombok.extern.slf4j.Slf4j;
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
public class DbBancoApplication {
    public static void main(String[] args) {
        // NOTE: Retire o .close() para manter a aplicação rodando
        var app = SpringApplication.run(DbBancoApplication.class, args);

//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        Validator validator = factory.getValidator();
//        System.out.println(validator.validate(
//                new Cliente("Carlos Masao Mito", "carlosmsmito@gmail.com", "(32) 98498-0040")
//        ));
//
//        app.close();
    }

//    public static void testeValidacaoCliente() {
//
//        // Teste da validação pelo Beans Annotation
//
//        List<Cliente> clientes = Arrays.asList(
//            new Cliente("Carlos Masao Mito", "123.456.789-00", "carlosmsmito@gmail.com", "(32) 92342-4353"),
//            new Cliente("Carlos Masao Mito", "123.456.789-00", "", "(32) 92342-4353"),
//            new Cliente("Carlos Masao Mito", "123.456.789-00", "abc245@", "(32) 92342-4353"),
//            new Cliente("Carlos Masao Mito", "123.456.789-00", "abc245", "(32) 92342-4353"),
//            new Cliente("Carlos Masao Mito", "123.456.789-00", "abc245@af@asd", "(32) 92342-4353"),
//            new Cliente("Carlos Masao Mito", "123.456.789-00", "carlosmsmito@gmail.com", "123456"),
//            new Cliente("Carlos Masao Mito", "123.456.789-00", "carlosmsmito@gmail.com", "123435256"),
//            new Cliente("Carlos Masao Mito", "123.456.789-00", "carlosmsmito@gmail.com", "(12) 12324-6456"),
//            new Cliente("Carlos Masao Mito", "123.456.789-00", "carlosmsmito@gmail.com", "(12) 2324-6456"),
//            new Cliente("Carlos Masao Mito", "12345678900", "carlosmsmito@gmail.com", "(32) 92342-4353"),
//            new Cliente("Carlos Masao Mito", "123.456.789.00", "carlosmsmito@gmail.com", "(32) 92342-4353"),
//            new Cliente("Carlos Masao Mito", "123", "carlosmsmito@gmail.com", "(32) 92342-4353"),
//            new Cliente("Carlos Masao Mito", "123456789060", "carlosmsmito@gmail.com", "(32) 92342-4353"),
//            new Cliente("", "123.456.789.00", "carlosmsmito@gmail.com", "(32) 92342-4353")
//        );
//
//        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
//            Validator validator = factory.getValidator();
//            clientes.forEach(cliente -> System.out.println(validator.validate(cliente)));
//        }
//    }
}
