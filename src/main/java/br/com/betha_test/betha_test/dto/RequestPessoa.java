package br.com.betha_test.betha_test.dto;

import br.com.betha_test.betha_test.orm.Pessoa;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RequestPessoa {
    @NotBlank
    protected String nome;
    @NotBlank
    @Size(min = 6)
    protected String senha;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

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

    public Pessoa toPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(this.nome);
        pessoa.setSenha(passwordEncoder().encode(this.senha));
//        pessoa.setSenha(this.senha);
        return pessoa;
    }
}
