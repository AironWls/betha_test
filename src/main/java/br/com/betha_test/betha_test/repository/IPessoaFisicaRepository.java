package br.com.betha_test.betha_test.repository;

import br.com.betha_test.betha_test.orm.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface IPessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

    List<PessoaFisica> findAll();

    Optional<PessoaFisica> findById(Long id);

}
