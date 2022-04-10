package br.com.letscode.dbbanco.view;

import br.com.letscode.dbbanco.controller.ClienteController;
import br.com.letscode.dbbanco.controller.ContaController;
import br.com.letscode.dbbanco.controller.EnderecoController;
import br.com.letscode.dbbanco.entities.Endereco;
import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.cliente.TipoCliente;
import br.com.letscode.dbbanco.entities.conta.Conta;
import br.com.letscode.dbbanco.entities.conta.TipoConta;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

@Component
public class Menu {

    static Scanner input = new Scanner(System.in);

    private final ClienteController clienteController;

    private final ContaController contaController;

    private final EnderecoController enderecoController;

    public Menu(ClienteController clienteController, ContaController contaController, EnderecoController enderecoController) {
        this.clienteController = clienteController;
        this.contaController = contaController;
        this.enderecoController = enderecoController;
    }

    public void painelInicio() {
        System.out.println(" ----------------------------------------------------- ");
        System.out.println("|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ Bem-vindo ao⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀|");
        System.out.println("|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀$⠀Banco Grupo Azul⠀$⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀|");
        System.out.println("|⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ |");
        System.out.println("|⠀⠀⠀⠀⠀⠀Selecione a operação que deseja realizar⠀⠀⠀⠀⠀⠀⠀ |");
        System.out.println(" ----------------------------------------------------- ");
        System.out.println("|    Opção 1 - Abrir conta         |");
        System.out.println("|    Opção 2 - Sacar               |");
        System.out.println("|    Opção 3 - Depositar           |");
        System.out.println("|    Opção 4 - Transferir          |");
        System.out.println("|    Opção 5 - Investir            |");
        System.out.println("|    Opção 6 - Consultar saldo     |");
        System.out.println("|    Opção 7 - Listar conta        |");
        System.out.println("|    Opção 8 - Excluir contas      |");
        System.out.println("|    Opção 9 - Sair                |");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                painelPessoa();
                break;
            case 2:
                painelSacar();
                break;
            case 3:
                painelDepositar();
                break;
            case 4:
                painelTransferir();
                break;
            case 5:
                painelInvestir();
                break;
            case 6:
                painelSaldo();
                break;
            case 7:
                painelListar();
                break;
            case 8:
                painelExcluir();
                break;
            case 9:
                System.out.println("Obrigado por utilizar o Banco Grupo Azul!");
                System.exit(0);
            default:
                System.out.println("Opção inválida!");
                painelInicio();
                break;
        }
    }

    private void painelListar() {
        var allContas = contaController.listarContas();
        System.out.println("Lista de Contas");
        allContas.forEach(System.out::println);
        painelInicio();
    }

    protected void painelPessoa() {
        System.out.println("|    Opção 1 - Pessoa Física      |");
        System.out.println("|    Opção 2 - Pessoa Jurídica    |");
        System.out.println("|    Opção 3 - Voltar             |");

        int tipoPessoa = input.nextInt();

        switch (tipoPessoa) {
            case 1:
                tipoPF();
                break;
            case 2:
                tipoPJ();
                break;
            case 3:
                painelInicio();
                break;
            default:
                System.out.println("Opção inválida!");
                painelPessoa();
                break;
        }
    }

    protected void tipoPF() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite seu nome: ");
        String nome = input.nextLine();

        System.out.println("\nDigite seu email: ");
        String email = input.nextLine();

        System.out.println("\nDigite seu telefone: ");
        String telefone = input.nextLine();

        System.out.println("\nDigite seu CPF, somente números: ");
        String cpf = input.nextLine();

        while (cpf.length() != 11) {
            System.out.println("Formato Inválido");
            System.out.println("\nDigite seu CPF, somente números: ");
            cpf = input.nextLine();
        }

        System.out.println("\nDigite sua data de nascimento, com barras: ");
        String dataNascimento = input.nextLine();

        var cliente = clienteController.createPF(nome, email, telefone, cpf, formatarData(dataNascimento));
        MapearEndereco(cliente, TipoCliente.PESSOA_FISICA);

    }

    protected void tipoPJ() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite sua razão social: ");
        String nome = input.nextLine();

        System.out.println("\nDigite seu email corporativo: ");
        String email = input.nextLine();

        System.out.println("\nDigite seu telefone: ");
        String telefone = input.nextLine();

        System.out.println("\nDigite seu CNPJ, somente números: ");
        String cnpj = input.nextLine();

        while (cnpj.length() != 14) {
            System.out.println("Formato Inválido");
            System.out.println("\nDigite seu CNPJ, somente números: ");
            cnpj = input.nextLine();
        }

        System.out.println("\nDigite a data de abertura da empresa, com barras: ");
        String dataAbertura = input.nextLine();

        var cliente = clienteController.createPJ(nome, email, telefone, cnpj, formatarData(dataAbertura));

        MapearEndereco(cliente, TipoCliente.PESSOA_JURIDICA);
    }


    protected void painelContasPF(Cliente cliente, Endereco endereco) {
        System.out.println("|    Opção 1 - Conta Corrente           |");
        System.out.println("|    Opção 2 - Conta Poupança           |");
        System.out.println("|    Opção 3 - Conta Investimento       |");
        System.out.println("|    Opção 4 - Voltar                   |");

        int tipoConta = input.nextInt();

        switch (tipoConta) {
            case 1:

                criarConta(cliente, TipoConta.CONTA_CORRENTE, TipoCliente.PESSOA_FISICA, endereco);


                break;
            case 2:
                criarConta(cliente, TipoConta.CONTA_POUPANCA, TipoCliente.PESSOA_FISICA, endereco);
                break;
            case 3:
                criarConta(cliente, TipoConta.CONTA_INVESTIMENTO, TipoCliente.PESSOA_FISICA, endereco);
                break;
            case 4:
                painelPessoa();
                break;
            default:
                System.out.println("Opção inválida!");
                painelContasPF(cliente, endereco);
                break;
        }
    }

    protected void painelContasPJ(Cliente cliente, Endereco endereco) {
        System.out.println("|    Opção 1 - Conta Corrente           |");
        System.out.println("|    Opção 2 - Conta Investimento       |");
        System.out.println("|    Opção 3 - Voltar                   |");

        int tipoContaPJ = input.nextInt();

        switch (tipoContaPJ) {
            case 1:
                criarConta(cliente, TipoConta.CONTA_CORRENTE, TipoCliente.PESSOA_JURIDICA, endereco);
                break;
            case 2:
                criarConta(cliente, TipoConta.CONTA_INVESTIMENTO, TipoCliente.PESSOA_JURIDICA, endereco);
                break;
            case 3:
                painelPessoa();
                break;
            default:
                System.out.println("Opção inválida!");
                tipoPJ();
                break;
        }
    }


    private void criarConta(Cliente cliente, TipoConta tipoConta, TipoCliente tipoCliente, Endereco endereco) {
        Scanner input = new Scanner(System.in);
        var agencia = painelAgencia();
        System.out.println("Digite sua senha");
        var senha = input.nextInt();
        var criarConta = new Conta(cliente, tipoConta, agencia, senha, tipoCliente, endereco);
        contaController.criarConta(criarConta);
        painelInicio();
    }

    public void painelSacar() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da conta: ");
        Integer numeroConta = Integer.valueOf(input.next());

        System.out.println("\nDigite a senha da conta: ");
        int senha = input.nextInt();

        System.out.println("\nDigite o valor do saque: ");
        BigDecimal valor = input.nextBigDecimal();

        var verifica = contaController.sacar(numeroConta, senha, valor);
        if (verifica) {
            painelInicio();
        } else {
            painelSacar();
        }
    }

    protected void painelDepositar() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da conta que deseja realizar o depósito: ");
        Integer numeroConta = Integer.valueOf(input.next());
        var verificaConta = contaController.validarConta(numeroConta);
        if (verificaConta) {
            System.out.println("\nDigite o valor do depósito: ");
            BigDecimal valor = input.nextBigDecimal();
            contaController.depositar(numeroConta, valor);
            painelInicio();
        } else {
            System.out.println("\nConta não encontrada!");
            painelDepositar();
        }
    }

    protected void painelInvestir() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da conta: ");
        Integer numeroConta = Integer.valueOf(input.next());

        System.out.println("\nDigite o valor do investimento: ");
        BigDecimal valor = input.nextBigDecimal();

        var verifica = contaController.investir(numeroConta, valor);
        if(verifica){
            painelInicio();
        } else{
            painelInvestir();
        }
    }

    protected void painelTransferir() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da sua conta: ");
        Integer contaRemetente = Integer.valueOf(input.next());

        System.out.println("\nDigite o número da conta que deseja enviar a transferência: ");
        Integer contaDestinataria = Integer.valueOf(input.next());

        System.out.println("\nDigite a senha da sua conta: ");
        int senha = input.nextInt();

        System.out.println("\nDigite o valor da transferência: ");
        BigDecimal valor = input.nextBigDecimal();

        var verifica = contaController.transferir(contaRemetente, contaDestinataria, senha, valor);
        if (verifica){
            painelInicio();
        } else{
            painelTransferir();
        }
    }


    protected void painelSaldo() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da conta: ");
        Integer numeroConta = Integer.valueOf(input.next());

        System.out.println("\nDigite a senha da conta: ");
        int senha = input.nextInt();

        var verifica = contaController.consultarSaldo(numeroConta, senha);
        if(verifica)
            painelInicio();
        else painelSaldo();
    }

    public void MapearEndereco(Cliente cliente, TipoCliente tipoCliente) {
        input.nextLine();

        System.out.println("Digite o logradouro:");
        String lagradouro = input.nextLine();


        System.out.println("Digite o numero:");
        String numero = input.nextLine();

        System.out.println("Digite a cidade:");
        String cidade = input.nextLine();

        System.out.println("Digite o bairro:");
        String bairro = input.nextLine();

        System.out.println("Digite o estado:");
        String estado = input.nextLine();

        System.out.println("Digite o pais:");
        String pais = input.nextLine();

        System.out.println("Digite o cep (Só os números):");
        String cep = input.nextLine();


        var criarEndereco = new Endereco(lagradouro, numero, cidade, bairro, estado, pais, cep, cliente);
        enderecoController.createEndereco(criarEndereco);
        
        if(tipoCliente == TipoCliente.PESSOA_JURIDICA){
            painelContasPJ(cliente, criarEndereco);
        } else{
            painelContasPF(cliente, criarEndereco);
        }
    }

    private void painelExcluir() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da conta: ");
        Integer numeroConta = Integer.valueOf(input.next());

        System.out.println("\nDigite a senha da conta: ");
        int senha = input.nextInt();
        input.nextLine();
        var verifica = contaController.validarLogin(numeroConta, senha);
        if(verifica){
            System.out.println("\nDeseja realmente EXCLUIR sua conta? Escreva: sim ou nao");
            String validacao = input.nextLine();
            if(validacao.equals("sim")) {
                contaController.excluirConta(numeroConta);
                painelInicio();
            } else {
                painelInicio();
            }
        } else {
            System.out.println("\nDados inválidos!");
            painelInicio();
        }
    }

    private int painelAgencia() {
        Scanner input = new Scanner(System.in);
        System.out.println("Escolha suas agencias:");
        System.out.println("Agencia: 101 - Agencia Sul");
        System.out.println("Agencia: 202 - Agencia Sudeste");
        System.out.println("Agencia: 303 - Agencia Centro-Oeste");
        System.out.println("Agencia: 404 - Agencia Nordeste");
        System.out.println("Agencia: 505 - Agencia Norte");

        return input.nextInt();
    }

    private LocalDate formatarData(String data) {

        String[] fields = data.split("/");

        return LocalDate.of(Integer.parseInt(fields[2]), Integer.parseInt(fields[1]), Integer.parseInt(fields[0]));

    }

}