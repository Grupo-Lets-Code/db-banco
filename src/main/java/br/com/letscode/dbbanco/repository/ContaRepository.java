package br.com.letscode.dbbanco.repository;

import br.com.letscode.dbbanco.entities.conta.ContaDefault;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface ContaRepository {

    // MARCOS

    // Sacar
    // Depositar
    // Transferir
    // Consultar Saldo

    BigDecimal sacar(BigDecimal valor);

    BigDecimal depositar(BigDecimal valor);

    BigDecimal transferir(BigDecimal valor, ContaRepository recebedora);

    String consultarSaldo();

}
