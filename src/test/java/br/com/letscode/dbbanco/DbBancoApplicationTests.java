package br.com.letscode.dbbanco;

import br.com.letscode.dbbanco.controller.ClienteController;
import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DbBancoApplication.class)
class DbBancoApplicationTests {

    @MockBean
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteController clienteController;

    @Test
    void loadCliente() {
        Cliente cliente = clienteRepository.getById(1);
        ResultSearch movieOneResult = getMovieResult(61);
    }

}
