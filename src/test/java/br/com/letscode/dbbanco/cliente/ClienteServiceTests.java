package br.com.letscode.dbbanco.cliente;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.cliente.ClientePF;
import br.com.letscode.dbbanco.entities.cliente.ClientePJ;
import br.com.letscode.dbbanco.exception.ClienteDuplicadoException;
import br.com.letscode.dbbanco.repository.ClientePFRepository;
import br.com.letscode.dbbanco.repository.ClienteRepository;
import br.com.letscode.dbbanco.service.ClienteService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteServiceTests {
    @Autowired
    ClienteService clienteService;

    @Test
    public void salvarClientePFTesteInteg() {
        Cliente cliente = new Cliente("Teste", "test@gmail.com", "(11) 90099-0040");

        ClientePF clientePF = new ClientePF("123.123.123-56", LocalDate.of(1999, 12, 12), cliente);

        clienteService.salvarCliente(cliente);
        ClientePF clienteSalvo = clienteService.salvarClientePF(clientePF);

        Assertions.assertNotNull(clienteSalvo.getId());
        Assertions.assertEquals(clienteSalvo.getCPF(), clientePF.getCPF());
    }

    @Test
    public void salvarClientePJTesteInteg() {
        Cliente cliente = new Cliente("Teste", "test@gmail.com", "(11) 90099-0040");

        ClientePJ clientePJ = new ClientePJ("11.222.333/0001-44", LocalDate.of(1999, 12, 12), cliente);

        clienteService.salvarCliente(cliente);
        ClientePJ clienteSalvo = clienteService.salvarClientePJ(clientePJ);

        Assertions.assertNotNull(clienteSalvo.getId());
        Assertions.assertEquals(clienteSalvo.getCNPJ(), clientePJ.getCNPJ());
    }

    /*@Test
    public void clienteRepetido() {
        Exception exception = Assertions.assertThrows(ClienteDuplicadoException.class, () -> {
            Cliente clienteSalvar = new Cliente("Teste", "test@gmail.com", "(11) 90099-0040");
            Cliente clienteRetorno = new Cliente(0,"Teste", "test@gmail.com", "(11) 90099-0040");
            clienteService.salvarCliente(clienteSalvar);
            clienteService.salvarCliente(clienteRetorno);
        });
        Assertions.assertEquals("Cliente Já Existe", exception.getMessage());
    }*/

}
