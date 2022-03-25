package br.com.betha_test.betha_test.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoas_fisica")
public class PessoaFisica extends Pessoa {
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    public PessoaFisica() {
    }

    public PessoaFisica(String cpf) {
        super();
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
