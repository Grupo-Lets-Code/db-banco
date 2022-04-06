package br.com.letscode.dbbanco.repository;

import br.com.letscode.dbbanco.entities.conta.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenciaRepository extends JpaRepository<Agencia, Integer> {

}
