package br.com.letscode.dbbanco.repository;

import br.com.letscode.dbbanco.entities.cliente.ClientePF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientePFRepository extends JpaRepository<ClientePF, Integer> {

}