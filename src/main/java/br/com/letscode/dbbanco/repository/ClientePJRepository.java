package br.com.letscode.dbbanco.repository;

import br.com.letscode.dbbanco.entities.cliente.ClientePJ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientePJRepository extends JpaRepository<ClientePJ, Integer> {

}