package br.com.letscode.dbbanco.cliente;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.entities.cliente.ClientePF;
import br.com.letscode.dbbanco.exception.ClienteNaoEncontradoException;
import br.com.letscode.dbbanco.repository.ClienteRepository;
import br.com.letscode.dbbanco.service.ClienteService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClienteTests {

    @InjectMocks
    private ClienteService clienteService;
    @Mock
    private ClienteRepository clienteRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void salvarClienteTeste() {
        Cliente clienteSalvar = new Cliente("Teste", "test@gmail.com", "(11) 90099-0040");
        Cliente clienteRetorno = new Cliente(0,"Teste", "test@gmail.com", "(11) 90099-0040");

        Mockito.when(clienteRepository.save(clienteSalvar))
                        .thenReturn(clienteRetorno);

        Assertions.assertEquals(clienteRepository.save(clienteSalvar).getNome(), clienteRetorno.getNome());
        Assertions.assertEquals(clienteRepository.save(clienteSalvar).getId(), clienteRetorno.getId());
        Assertions.assertEquals(clienteRepository.save(clienteSalvar).getEmail(), clienteRetorno.getEmail());
    }

}
