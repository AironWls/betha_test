package br.com.betha_test.betha_test.apicontroller;

import br.com.betha_test.betha_test.dto.RequestPessoaJuridica;
import br.com.betha_test.betha_test.orm.PessoaJuridica;
import br.com.betha_test.betha_test.repository.IPessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoajuridica")
public class PessoaJuridicaController {

    @Autowired
    IPessoaJuridicaRepository pessoaJuridicaRepository;

    @GetMapping
    public List<PessoaJuridica> index() {
        return pessoaJuridicaRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<PessoaJuridica> show(@PathVariable Long id) {
        return pessoaJuridicaRepository.findById(id);
    }


    @PostMapping("store")
    public String store(@RequestBody @Valid RequestPessoaJuridica requestPessoaJuridica, BindingResult result) {
        if(result.hasErrors()) {
            System.out.println(result.getAllErrors());
        }
        PessoaJuridica pj = requestPessoaJuridica.toPessoaJuridica();
        pessoaJuridicaRepository.save(pj);
        return "200";
    }

}
