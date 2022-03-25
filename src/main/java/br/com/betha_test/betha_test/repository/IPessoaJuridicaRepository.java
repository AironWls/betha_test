package br.com.betha_test.betha_test.repository;

import br.com.betha_test.betha_test.orm.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

}
