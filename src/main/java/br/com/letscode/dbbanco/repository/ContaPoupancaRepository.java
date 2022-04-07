package br.com.letscode.dbbanco.repository;

import br.com.letscode.dbbanco.entities.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaPoupancaRepository extends JpaRepository<Conta, Integer> {
}
