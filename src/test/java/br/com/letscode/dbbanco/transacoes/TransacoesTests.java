package br.com.letscode.dbbanco.transacoes;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import br.com.letscode.dbbanco.repository.ClienteRepository;
import br.com.letscode.dbbanco.repository.ContaRepository;
import br.com.letscode.dbbanco.service.ClienteService;
import br.com.letscode.dbbanco.service.TransacaoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TransacoesTests {
    @InjectMocks
    private TransacaoService transacaoService;
    @Mock
    private ContaRepository contaRepository;


    @Test
    void saqueTeste() {
        //TODO desenvolver teste
    }

    @Test
    void depositoTeste() {
        //TODO desenvolver teste
    }
}
