package br.com.letscode.dbbanco.repository;

import br.com.letscode.dbbanco.entities.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

    Optional<Conta> findByNumeroConta(Integer numeroConta);
    Optional<Conta> findByNumeroContaAndSenha(Integer numeroConta, int senha);

    @Transactional
    void deleteByNumeroConta(Integer numeroConta);

    @Query("SELECT c FROM Conta c WHERE c.cliente.id = :id")
    List<Conta> findContasByClienteID(Integer id);

}
