package br.com.letscode.dbbanco.repository;

import br.com.letscode.dbbanco.entities.cliente.ClientePF;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientePFRepository extends JpaRepository<ClientePF, Integer> {
}