package br.com.betha_test.betha_test.repository;

import br.com.betha_test.betha_test.orm.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findByNome(String nome);

}
