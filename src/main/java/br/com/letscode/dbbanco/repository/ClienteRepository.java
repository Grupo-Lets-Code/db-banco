package br.com.letscode.dbbanco.repository;

import br.com.letscode.dbbanco.entities.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Override
    Optional<Cliente> findById(Integer integer);
}
