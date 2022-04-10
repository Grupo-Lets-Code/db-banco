package br.com.letscode.dbbanco.view.endereco;

import br.com.letscode.dbbanco.controller.ContaController;
import br.com.letscode.dbbanco.controller.EnderecoController;
import br.com.letscode.dbbanco.entities.Endereco;
import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.cliente.TipoCliente;
import br.com.letscode.dbbanco.entities.conta.Conta;
import br.com.letscode.dbbanco.view.Menu;
import br.com.letscode.dbbanco.view.conta.ContaView;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class EnderecoView {

    private final EnderecoController enderecoController;
    private final ContaController contaController;
    private final ContaView contaView;
    private final Menu menuView;

    public EnderecoView(@Lazy ContaView contaView, EnderecoController enderecoController, ContaController contaController, @Lazy Menu menuView) {
        this.contaView = contaView;
        this.contaController = contaController;
        this.enderecoController = enderecoController;
        this.menuView = menuView;
    }

    public void mapearEndereco(Cliente cliente, TipoCliente tipoCliente) {

        Endereco endereco = new Endereco();
        instanciarEndereco(endereco);

        enderecoController.createEndereco(endereco);

        if(tipoCliente == TipoCliente.PESSOA_JURIDICA){
            contaView.painelContasPJ(cliente, endereco);
        } else{
            contaView.painelContasPF(cliente, endereco);
        }
    }

    public void instanciarEndereco(Endereco endereco) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o logradouro:");
        String logradouro = input.nextLine();

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

        System.out.println("Digite o cep, somente os números: ");
        String cep = input.nextLine();

        endereco.setLogradouro(logradouro);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setCep(cep);
        endereco.setPais(pais);
        endereco.setUf(estado);
        endereco.setNumero(numero);
    }

    public void painelAlterarEndereco() {

        Scanner input = new Scanner(System.in);

        System.out.println("\nDigite o número da conta: ");
        Integer numeroConta = Integer.valueOf(input.next());

        System.out.println("\nDigite a senha da conta: ");
        int senha = input.nextInt();

        if(contaController.validarLogin(numeroConta, senha)) {
            Conta conta = contaController.recuperaContaPorNumero(numeroConta);
            Endereco endereco = enderecoController.recuperaEnderecoPorId(conta.getEndereco().getId());
            instanciarEndereco(endereco);
            enderecoController.updateEndereco(endereco);
            menuView.painelInicio();

        } else {
            System.out.println("Os dados inseridos estão incorretos, tente novamente!");
            painelAlterarEndereco();
        }


    }

}
