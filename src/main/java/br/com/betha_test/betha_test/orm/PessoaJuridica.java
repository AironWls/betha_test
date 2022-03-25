package br.com.betha_test.betha_test.orm;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;

@Entity
@Table(name = "pessoas_juridica")
public class PessoaJuridica extends Pessoa{

    @Column(nullable = false, unique = true, length = 14)
    @CNPJ
    private String cnpj;

    public PessoaJuridica() {
    }



    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
