package br.com.betha_test.betha_test.dto;

import br.com.betha_test.betha_test.orm.PessoaFisica;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RequestPessoaFisica {
    @NotBlank
    private String nome;
    @NotBlank
    @Size(min=6)
    private String senha;
    @NotBlank
    @CPF
    private String cpf;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public PessoaFisica toPessoaFisica() {
        PessoaFisica pf = new PessoaFisica();
        pf.setNome(this.nome);
        pf.setSenha(this.senha);
        pf.setCpf(this.cpf);
        return pf;
    }

    @Override
    public String toString() {
        return "RequestPessoaFisica{" +
                "nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
