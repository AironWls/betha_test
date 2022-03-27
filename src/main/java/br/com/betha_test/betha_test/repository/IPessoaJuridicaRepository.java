package br.com.betha_test.betha_test.repository;

import br.com.betha_test.betha_test.orm.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

    List<PessoaJuridica> findAll();

    Optional<PessoaJuridica> findById(Long id);

}
