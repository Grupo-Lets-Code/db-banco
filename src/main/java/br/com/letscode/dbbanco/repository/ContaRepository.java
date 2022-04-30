package br.com.letscode.dbbanco.repository;

import br.com.letscode.dbbanco.entities.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
    Optional<Conta> findByNumeroConta(Integer integer);

    Optional<Conta> findByNumeroContaAndSenha(Integer numeroConta, int senha);

    @Transactional
    void deleteByNumeroConta(Integer numeroConta);

}
