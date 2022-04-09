package br.com.letscode.dbbanco.entities.conta;

import br.com.letscode.dbbanco.entities.cliente.TipoCliente;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ContaFactory {

    public BigDecimal valorTipoConta(Conta conta, BigDecimal valor) {
        var tipoConta = conta.getTipoConta();
        if(conta.getTipoCliente() == TipoCliente.PESSOA_JURIDICA){
            switch (tipoConta) {
                case CONTA_POUPANCA:
                    break;
                case CONTA_CORRENTE:
                    return valor.multiply(BigDecimal.valueOf(1.005));
                case CONTA_INVESTIMENTO:
                    return valor.multiply(BigDecimal.valueOf(1.02));
                default:
                   throw new IllegalArgumentException("Opção inválida!");
            }
        }
        return valor;
    }
}
