package br.com.betha_test.betha_test.dto;

import br.com.betha_test.betha_test.orm.PessoaFisica;
import org.hibernate.validator.constraints.br.CPF;
import javax.persistence.Column;
import javax.validation.constraints.NotBlank;


public class RequestPessoaFisica extends RequestPessoa {

    @NotBlank
    @CPF
    @Column(unique = true)
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public PessoaFisica toPessoaFisica() {
        PessoaFisica pf = new PessoaFisica();
        pf.setNome(super.nome);
        pf.setSenha(this.senha);
        pf.setCpf(this.cpf);
        return pf;
    }
}
