package br.com.betha_test.betha_test.form;

import br.com.betha_test.betha_test.orm.PessoaFisica;
import br.com.betha_test.betha_test.orm.PessoaJuridica;
import br.com.betha_test.betha_test.repository.IPessoaFisicaRepository;
import br.com.betha_test.betha_test.repository.IPessoaJuridicaRepository;
import org.hibernate.validator.constraints.br.CNPJ;
import javax.validation.constraints.NotBlank;


public class RequestPessoaJuridica extends RequestPessoa {

    @NotBlank
    @CNPJ
    private String cnpj;

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

    public PessoaJuridica update(Long id, IPessoaJuridicaRepository pessoaJuridicaRepository) {
        PessoaJuridica pj = pessoaJuridicaRepository.getById(id);
        pj.setNome(this.nome);
        pj.setSenha(this.senha);
        pj.setCnpj(this.cnpj);
        return pj;
    }
}
