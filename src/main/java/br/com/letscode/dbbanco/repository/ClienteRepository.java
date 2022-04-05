package br.com.letscode.dbbanco.repository;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value = "SELECT MAX(ID) FROM CLIENTE", nativeQuery = true)
    int catTheLastId();

}
