package br.com.betha_test.betha_test.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RequestLogin {
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String senha;

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
}
