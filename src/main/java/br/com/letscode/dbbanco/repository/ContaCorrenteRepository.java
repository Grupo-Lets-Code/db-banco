package br.com.letscode.dbbanco.repository;

import br.com.letscode.dbbanco.entities.conta.Corrente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaCorrenteRepository extends JpaRepository<Corrente, Integer> {

    // Sacar
    // Depositar
    // Transferir
    // Consultar Saldo

}
