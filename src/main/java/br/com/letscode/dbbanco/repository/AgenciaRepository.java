package br.com.letscode.dbbanco.repository;

import br.com.letscode.dbbanco.entities.conta.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Integer> {

    Optional<Agencia> findByNumeroAgencia(Integer numero);

}
