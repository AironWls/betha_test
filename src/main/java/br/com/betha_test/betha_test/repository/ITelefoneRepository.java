package br.com.betha_test.betha_test.repository;

import br.com.betha_test.betha_test.orm.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITelefoneRepository extends JpaRepository<Telefone, Long> {

}
