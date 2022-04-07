package br.com.letscode.dbbanco;

import br.com.letscode.dbbanco.entities.conta.Agencia;
import br.com.letscode.dbbanco.repository.AgenciaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

@SpringBootApplication
public class DbBancoApplication implements CommandLineRunner{

    private final AgenciaRepository agenciaRepository;

    public DbBancoApplication(AgenciaRepository agenciaRepository) {
        this.agenciaRepository = agenciaRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DbBancoApplication.class, args);
    }

    @Override
    public void run(String... args){
        agenciaRepository.save(new Agencia(101, "Agencia Guarulhos"));
        agenciaRepository.save(new Agencia(202, "Agencia Saão Paulo"));
        agenciaRepository.save(new Agencia(303, "Agencia Campinas"));
        agenciaRepository.save(new Agencia(404, "Agencia Ubatuba"));

        List<Agencia> agenciaList = agenciaRepository.findAll();

        agenciaList.stream().forEach(System.out::println);

    }
}
