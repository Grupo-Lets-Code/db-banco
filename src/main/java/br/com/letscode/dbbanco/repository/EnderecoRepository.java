package br.com.letscode.dbbanco.repository;


import br.com.letscode.dbbanco.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Integer> {



}
