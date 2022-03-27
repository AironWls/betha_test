package br.com.betha_test.betha_test.dto;

import br.com.betha_test.betha_test.orm.PessoaJuridica;

import java.util.List;
import java.util.stream.Collectors;

public class PessoaJuridicaDto {
    private Long id;
    private String nome;
    private String senha;
    private String cnpj;

    public PessoaJuridicaDto(PessoaJuridica pj) {
        this.id = pj.getId();
        this.nome = pj.getNome();
        this.senha = pj.getSenha();
        this.cnpj = pj.getCnpj();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getCnpj() {
        return cnpj;
    }

    public static List<PessoaJuridicaDto> converter(List<PessoaJuridica> pessoaJuridicas) {
        return pessoaJuridicas.stream().map(PessoaJuridicaDto::new).collect(Collectors.toList());
    }
}
