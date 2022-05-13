package br.com.letscode.dbbanco.cliente;

import br.com.letscode.dbbanco.controller.ClienteController;
import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.service.ClienteService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@ContextConfiguration
@WebMvcTest(value = ClienteController.class)
@AutoConfigureMockMvc(addFilters = false)
public class ClienteControllerTests {

    @MockBean
    private ClienteService clienteService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    public void salvarClienteTestController() throws Exception {

        Cliente cliente = new Cliente("Teste", "test@gmail.com", "(11) 90099-0040");

        Cliente clienteEsperado = new Cliente("Teste", "test@gmail.com", "(11) 90099-0040");
        Mockito.when(clienteService.salvarCliente(cliente))
                .thenReturn(clienteEsperado);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/clientes/novo")
                                .flashAttr("cliente", cliente)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
        ;

        Assertions.assertEquals(cliente.getEmail(), clienteEsperado.getEmail());
    }
}
