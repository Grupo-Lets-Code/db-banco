package br.com.letscode.dbbanco.repository;

import br.com.letscode.dbbanco.entities.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.transaction.Transactional;
import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

    Optional<Conta> findByNumeroConta(Integer numeroConta);
    Optional<Conta> findBySenhaEquals(int senha);

    @Transactional
    void deleteByNumeroConta(Integer numeroConta);

}
