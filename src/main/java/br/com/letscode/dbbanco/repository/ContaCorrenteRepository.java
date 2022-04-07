package br.com.letscode.dbbanco.repository;

import br.com.letscode.dbbanco.controller.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaCorrenteRepository extends JpaRepository<Conta, Integer> {

    // Sacar
    // Depositar
    // Transferir
    // Consultar Saldo

}
