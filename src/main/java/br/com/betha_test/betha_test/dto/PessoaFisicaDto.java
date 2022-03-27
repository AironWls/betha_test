package br.com.betha_test.betha_test.dto;

import br.com.betha_test.betha_test.orm.PessoaFisica;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class PessoaFisicaDto {
    private Long id;
    private String nome;
    private String senha;
    private String cpf;

    public PessoaFisicaDto(PessoaFisica pessoaFisica) {
        this.id = pessoaFisica.getId();
        this.nome = pessoaFisica.getNome();
        this.senha = pessoaFisica.getSenha();
        this.cpf = pessoaFisica.getCpf();
    }

    /*public static List<PessoaFisicaDto> converter(List<PessoaFisica> pfs) {
        return pfs.stream().map(PessoaFisicaDto::new).collect(Collectors.toList());
    }*/

    public static Page<PessoaFisicaDto> converter(Page<PessoaFisica> pfs) {
        return pfs.map(PessoaFisicaDto::new);
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

}
