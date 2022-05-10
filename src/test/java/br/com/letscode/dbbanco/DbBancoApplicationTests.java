package br.com.letscode.dbbanco;

import br.com.letscode.dbbanco.controller.ClienteController;
import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.repository.ClienteRepository;
import br.com.letscode.dbbanco.service.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class DbBancoApplicationTests {

    @MockBean
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;

    @Test
    void salvarClienteTeste() {
        Cliente clienteSalvar = new Cliente("Teste", "test@gmail.com", "(11) 90099-0040");
        Cliente clienteRetorno = new Cliente(7, "Teste", "test@gmail.com", "(11) 90099-0040");

        Mockito.when(clienteRepository.save(clienteSalvar))
                        .thenReturn(clienteRetorno);

        clienteRetorno = clienteService.salvarCliente(clienteSalvar);

        Assertions.assertEquals(clienteRetorno.getNome(), clienteSalvar.getNome());
        Assertions.assertEquals(clienteRetorno.getId(), 7);
    }

}
