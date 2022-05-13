package br.com.letscode.dbbanco.cliente;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.cliente.ClientePF;
import br.com.letscode.dbbanco.entities.cliente.ClientePJ;
import br.com.letscode.dbbanco.exception.ClienteDuplicadoException;
import br.com.letscode.dbbanco.exception.ClienteNaoEncontradoException;
import br.com.letscode.dbbanco.repository.ClientePFRepository;
import br.com.letscode.dbbanco.repository.ClientePJRepository;
import br.com.letscode.dbbanco.repository.ClienteRepository;
import br.com.letscode.dbbanco.service.ClienteService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ClientePJTests {

    @InjectMocks
    private ClienteService clienteService;
    @Mock
    private ClienteRepository clienteRepository;
    @Mock
    private ClientePJRepository clientePJRepository;
    @Mock
    private ClientePFRepository clientePFRepository;
    private AutoCloseable closeable;

    @BeforeEach
    public void setUp(){
        closeable = MockitoAnnotations.openMocks(this);
        clienteService = new ClienteService(clienteRepository, clientePFRepository, clientePJRepository);
    }

    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

    @Test
    public void salvarClientePJTeste(){
        Cliente cliente = new Cliente("Teste2", "test2@gmail.com", "(11) 90099-0040");
        ClientePJ clientePJ = new ClientePJ("11.222.333/0001-44", LocalDate.of(1999, 12, 12), cliente);
        ClientePJ clientePJRetorno = new ClientePJ(0, "11.222.333/0001-44", LocalDate.of(1999, 12, 12), cliente);


        clienteService.salvarCliente(cliente);
        Mockito.when(clientePJRepository.save(clientePJ))
                .thenReturn(clientePJRetorno);
        Assertions.assertNotNull(clientePJRetorno.getId());
    }
}
