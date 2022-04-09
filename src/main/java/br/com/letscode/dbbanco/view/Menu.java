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
import java.util.Arrays;
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
        allContas.stream().forEach(System.out::println);
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

        System.out.println("\nDigite sua data de nascimento: ");
        String data_nascimento = input.nextLine();

        var cliente = clienteController.createPF(nome, email, telefone, cpf, data_nascimento);
        MapearEndereco(cliente);
        painelContasPF();

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
        String data = input.nextLine();

        String[] fields = data.split("/");

        var data_abertura = LocalDate.of(Integer.parseInt(fields[2]),
                Integer.parseInt(fields[1]), Integer.parseInt(fields[0]));

        var cliente = clienteController.createPJ(nome, email, telefone, cnpj, data_abertura);

        MapearEndereco(cliente);
        //painelContasPJ(cliente);
    }


    protected void painelContasPF() {
        System.out.println("|    Opção 1 - Conta Corrente           |");
        System.out.println("|    Opção 2 - Conta Poupança           |");
        System.out.println("|    Opção 3 - Conta Investimento       |");
        System.out.println("|    Opção 4 - Voltar                   |");

        int tipoConta = input.nextInt();

        switch (tipoConta) {
            case 1:
                //Chamar o metodo abrir conta corrente
                break;
            case 2:
                //Chamar o metodo abrir conta poupança
                break;
            case 3:
                //Chamar o metodo abrir conta investimento
                break;
            case 4:
                painelPessoa();
                break;
            default:
                System.out.println("Opção inválida!");
                painelContasPF();
                break;
        }
    }

    protected void painelContasPJ(Cliente cliente) {
        System.out.println("|    Opção 1 - Conta Corrente           |");
        System.out.println("|    Opção 2 - Conta Investimento       |");
        System.out.println("|    Opção 3 - Voltar                   |");

        int tipoContaPJ = input.nextInt();

        switch (tipoContaPJ) {
            case 1:
                painelCriarCorrentePJ(cliente);
                break;
            case 2:
                //Banco.criarInvestimentoPJ();
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
    /*
    private void painelCriarCorrentePF(Cliente cliente) {
        Scanner input = new Scanner(System.in);
        var agencia = painelAgencia();
        System.out.println("Digite sua senha");
        var senha = input.nextInt();
        var criarConta = new Conta(cliente,TipoConta.CONTA_CORRENTE,agencia, senha, TipoCliente.PESSOA_JURIDICA);
        contaController.criarConta(criarConta);
        painelInicio();
    }*/

    private void painelCriarCorrentePJ(Cliente cliente) {
        Scanner input = new Scanner(System.in);
        var agencia = painelAgencia();
        System.out.println("Digite sua senha de 6 digitos: ");
        var senha = input.nextInt();
        var criarConta = new Conta(cliente, TipoConta.CONTA_CORRENTE, agencia, senha, TipoCliente.PESSOA_JURIDICA);
        contaController.criarConta(criarConta);
        painelInicio();
    }

    protected Boolean acessarConta(Integer numeroConta, int senha) {
        var valida = contaController.validarLogin(numeroConta, senha);
        if (valida) {
            return true;
        }
        return false;
    }


    public void painelSacar() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da conta: ");
        Integer numeroConta = Integer.valueOf(input.next());

        System.out.println("\nDigite a senha da conta: ");
        int senha = input.nextInt();

        if (acessarConta(numeroConta, senha)) {
            System.out.println("\nDigite o valor do saque: ");
            BigDecimal valor = input.nextBigDecimal();
            var verifica = contaController.sacar(numeroConta, valor);
            if (verifica) {
                painelInicio();
            } else {
                painelSacar();
            }
        } else {
            System.out.println("\nDados inválidos!");
            painelInicio();
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

        //FIXME Validar se a conta existe antes de passar para a senha
        //Exemplo: contaExists(); para verificar se a conta existe

        //FIXME SE CONTA NÃO EXISTE:
        System.out.println("\nConta inválida!");
        painelInvestir();


        System.out.println("\nDigite o valor do investimento: ");
        BigDecimal valor = input.nextBigDecimal();

        contaController.investir(numeroConta, valor);

        System.out.println("\nInvestimento no valor de " + valor + "R$ realizado com sucesso! Saldo atual: " /*saldo*/);

    }

    protected void painelTransferir() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da sua conta: ");
        Integer contaRemetente = Integer.valueOf(input.next());

        System.out.println("\nDigite o número da conta que deseja enviar a transferência: ");
        Integer contaDestinataria = Integer.valueOf(input.next());

        //FIXME Validar se as contas existem antes de passar para a senha
        //Exemplo: contaExists(); para verificar se as contas existem

        /*
        System.out.println("\nConta remetente inválida!");
        contaRemetente = Integer.valueOf(input.next());


        System.out.println("\nConta destinatária inválida!");
        contaDestinataria = Integer.valueOf(input.next());
        */


        System.out.println("\nDigite a senha da sua conta: ");
        int senha = input.nextInt();

        System.out.println("\nSenha inválida!");
        painelTransferir();

        //FIXME SE SENHA CORRETA, então
        System.out.println("\nDigite o valor da transferência: ");
        BigDecimal valor = input.nextBigDecimal();

        contaController.transferir(contaRemetente, contaDestinataria, senha, valor);

        System.out.println("\nTransferência no valor de " + valor + "R$ realizada com sucesso! Saldo atual: " /*saldo*/);


    }


    protected void painelSaldo() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da conta: ");
        Integer numeroConta = Integer.valueOf(input.next());

        System.out.println("\nDigite a senha da conta: ");
        int senha = input.nextInt();

        contaController.consultarSaldo(numeroConta, senha);

        //FIXME Validar se a conta existe antes de passar para a senha
        //Exemplo: contaExists(); para verificar se a conta existe

        //FIXME SE CONTA NÃO EXISTE:
        System.out.println("\nConta inválida!");
        painelSaldo();


        //FIXME SE SENHA INCORRETA, então
        System.out.println("\nSenha inválida!");
        painelSaldo();
    }

    public void MapearEndereco(Cliente cliente) {
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

        painelContasPJ(cliente);
    }

    private void painelExcluir() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da conta: ");
        Integer numeroConta = Integer.valueOf(input.next());

        System.out.println("\nDigite a senha da conta: ");
        int senha = input.nextInt();
        input.nextLine();

        if (acessarConta(numeroConta, senha)) {
            System.out.println("\nDeseja realmente EXCLUIR sua conta? Escreva: sim ou nao");
            String validacao = input.nextLine();
            if (validacao.equals("sim")) {
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
        System.out.println("Agencia: 101");
        System.out.println("Agencia: 202");
        System.out.println("Agencia: 303");
        System.out.println("Agencia: 404");

        return input.nextInt();
    }

}