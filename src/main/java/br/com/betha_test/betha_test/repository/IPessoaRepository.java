package br.com.betha_test.betha_test.repository;

import br.com.betha_test.betha_test.orm.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPessoaRepository extends JpaRepository<Pessoa, Long> {



}
