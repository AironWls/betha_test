package br.com.betha_test.betha_test.dto;

import br.com.betha_test.betha_test.orm.PessoaJuridica;
import org.hibernate.validator.constraints.br.CNPJ;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RequestPessoaJuridica {
    @NotBlank
    private String nome;
    @NotBlank
    @Size(min=6)
    private String senha;
    @NotBlank
    @CNPJ
    private String cnpj;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public PessoaJuridica toPessoaJuridica() {
        PessoaJuridica pj = new PessoaJuridica();
        pj.setNome(this.nome);
        pj.setCnpj(this.cnpj);
        pj.setSenha(this.senha);
        return pj;
    }
}
