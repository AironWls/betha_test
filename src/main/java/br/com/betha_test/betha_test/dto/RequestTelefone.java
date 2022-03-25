package br.com.betha_test.betha_test.dto;

import br.com.betha_test.betha_test.orm.Telefone;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RequestTelefone {
    @NotBlank
    @Size(min = 2, max = 2)
    private String ddd;
    @NotBlank
    @Size(min = 9, max = 9)
    private String telefone;

    public RequestTelefone() {
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Telefone toTelefone() {
        Telefone tel = new Telefone();
        tel.setDdd(this.ddd);
        tel.setTelefone(this.telefone);

        return tel;
    }
}
