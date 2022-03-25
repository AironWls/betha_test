package br.com.betha_test.betha_test.repository;

import br.com.betha_test.betha_test.orm.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IPessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {

    List<PessoaFisica> findAll();

}
