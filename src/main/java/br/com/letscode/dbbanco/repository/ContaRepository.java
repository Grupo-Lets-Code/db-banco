package br.com.letscode.dbbanco.repository;

import br.com.letscode.dbbanco.controller.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

/*
    BigDecimal sacar(BigDecimal valor);

    BigDecimal depositar(BigDecimal valor);

    BigDecimal transferir(BigDecimal valor, ContaRepository recebedora);

    String consultarSaldo();
*/
}
