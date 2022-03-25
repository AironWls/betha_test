package br.com.betha_test.betha_test.apicontroller;

import br.com.betha_test.betha_test.dto.RequestPessoaFisica;
import br.com.betha_test.betha_test.orm.PessoaFisica;
import br.com.betha_test.betha_test.repository.IPessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoafisica")
public class PessoaFisicaController {

    @Autowired
    IPessoaFisicaRepository pessoaFisicaRepository;

    @PostMapping("store")
    public void store(@Valid @RequestBody RequestPessoaFisica requestPessoaFisica, BindingResult result) {
        if(result.hasErrors()) {
            System.exit(400);
        }
        PessoaFisica pf = requestPessoaFisica.toPessoaFisica();
        pessoaFisicaRepository.save(pf);
    }

    @GetMapping
    public List<PessoaFisica> index() {
        return pessoaFisicaRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<PessoaFisica> show(@PathVariable Long id) {
        return pessoaFisicaRepository.findById(id);
    }


}
