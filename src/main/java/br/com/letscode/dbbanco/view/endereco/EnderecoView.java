package br.com.letscode.dbbanco.view.endereco;

import br.com.letscode.dbbanco.controller.EnderecoController;
import br.com.letscode.dbbanco.entities.Endereco;
import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.cliente.TipoCliente;
import br.com.letscode.dbbanco.view.conta.ContaView;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class EnderecoView {

    private final EnderecoController enderecoController;
    private final ContaView contaView;

    public EnderecoView(@Lazy ContaView contaView, EnderecoController enderecoController) {
        this.contaView = contaView;
        this.enderecoController = enderecoController;
    }

    public void mapearEndereco(Cliente cliente, TipoCliente tipoCliente) {
        Scanner input = new Scanner(System.in);

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

        System.out.println("Digite o cep, somente os números: ");
        String cep = input.nextLine();

        var criarEndereco = new Endereco(lagradouro, numero, cidade, bairro, estado, pais, cep, cliente);
        enderecoController.createEndereco(criarEndereco);

        if(tipoCliente == TipoCliente.PESSOA_JURIDICA){
            contaView.painelContasPJ(cliente, criarEndereco);
        } else{
            contaView.painelContasPF(cliente, criarEndereco);
        }
    }

}
