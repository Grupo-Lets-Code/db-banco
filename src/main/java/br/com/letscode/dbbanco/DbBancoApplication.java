package br.com.letscode.dbbanco;

import br.com.letscode.dbbanco.entities.Endereco;
import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.conta.Agencia;
import br.com.letscode.dbbanco.repository.AgenciaRepository;
import br.com.letscode.dbbanco.repository.EnderecoRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class DbBancoApplication implements CommandLineRunner{
    static Scanner input = new Scanner(System.in);
    private final AgenciaRepository agenciaRepository;

    private final EnderecoRepository enderecoRepository;


    public DbBancoApplication(AgenciaRepository agenciaRepository, EnderecoRepository enderecoRepository) {
        this.agenciaRepository = agenciaRepository;
        this.enderecoRepository = enderecoRepository;
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

        System.out.println("Digite o logradouro:");
        String lagradouro = input.next();

        System.out.println("Digite o numero:");
        String numero = input.next();

        System.out.println("Digite a cidade:");
        String cidade = input.nextLine();

        System.out.println("Digite o bairro:");
        String bairro = input.nextLine();

        System.out.println("Digite o estado:");
        String estado = input.nextLine();

        System.out.println("Digite o pais:");
        String pais = input.nextLine();

        System.out.println("Digite o cep (Só os números):");
        int cep = input.nextInt();

        var criarCliente = new Cliente("Rafael","rafael@gmail.com","11977507307");
        var criarEndereco = new Endereco(lagradouro,numero,cidade,bairro,estado,pais,cep, criarCliente);
        enderecoRepository.save(criarEndereco);

    }
    //public static void MapearEndereco(){
    //
//
//
    //    System.out.println("Digite o logradouro:");
    //    String lagradouro = input.next();
//
    //    System.out.println("Digite o numero:");
    //    String numero = input.next();
//
    //    System.out.println("Digite a cidade:");
    //    String cidade = input.nextLine();
//
    //    System.out.println("Digite o bairro:");
    //    String bairro = input.nextLine();
//
    //    System.out.println("Digite o estado:");
    //    String estado = input.nextLine();
//
    //    System.out.println("Digite o pais:");
    //    String pais = input.nextLine();
//
    //    System.out.println("Digite o cep (Só os números):");
    //    int cep = input.nextInt();
//
    //    var criarCliente = new Cliente("Rafael","rafael@gmail.com","11977507307");
    //    var criarEndereco = new Endereco(lagradouro,numero,cidade,bairro,estado,pais,cep, criarCliente);
    //    enderecoRepository
//
    //}

}
