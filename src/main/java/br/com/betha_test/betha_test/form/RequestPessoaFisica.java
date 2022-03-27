package br.com.betha_test.betha_test.form;

import br.com.betha_test.betha_test.orm.PessoaFisica;
import br.com.betha_test.betha_test.repository.IPessoaFisicaRepository;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.NotBlank;

public class RequestPessoaFisica extends RequestPessoa {

    @NotBlank
    @CPF
    private String cpf;

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

    public PessoaFisica update(Long id, IPessoaFisicaRepository pessoaFisicaRepository) {
        PessoaFisica pf = pessoaFisicaRepository.getById(id);
        pf.setNome(this.nome);
        pf.setSenha(this.senha);
        pf.setCpf(this.cpf);
        return pf;
    }
}
