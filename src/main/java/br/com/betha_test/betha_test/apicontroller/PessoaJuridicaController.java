package br.com.betha_test.betha_test.apicontroller;

import br.com.betha_test.betha_test.dto.PessoaFisicaDto;
import br.com.betha_test.betha_test.dto.PessoaJuridicaDto;
import br.com.betha_test.betha_test.form.RequestPessoaFisica;
import br.com.betha_test.betha_test.form.RequestPessoaJuridica;
import br.com.betha_test.betha_test.orm.PessoaFisica;
import br.com.betha_test.betha_test.orm.PessoaJuridica;
import br.com.betha_test.betha_test.repository.IPessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoajuridica")
public class PessoaJuridicaController {

    @Autowired
    IPessoaJuridicaRepository pessoaJuridicaRepository;

    @GetMapping
    public Page<PessoaJuridicaDto> index(Pageable paginacao) {

        Page<PessoaJuridica> pjs = pessoaJuridicaRepository.findAll(paginacao);
        return PessoaJuridicaDto.converter(pjs);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PessoaJuridicaDto> show(@PathVariable Long id) {
        Optional<PessoaJuridica> pj = pessoaJuridicaRepository.findById(id);
        if(pj.isPresent()) {
            return ResponseEntity.ok(new PessoaJuridicaDto(pj.get()));
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping("store")
    @Transactional
    public ResponseEntity<PessoaJuridicaDto> store(@RequestBody @Valid RequestPessoaJuridica requestPessoaJuridica, BindingResult result, UriComponentsBuilder uriBuilder) {

        PessoaJuridica pj = requestPessoaJuridica.toPessoaJuridica();
        pessoaJuridicaRepository.save(pj);
        URI uri = uriBuilder.path("/api/pessoajuridica/{id}").buildAndExpand(pj.getId()).toUri();
        return ResponseEntity.created(uri).body(new PessoaJuridicaDto(pj));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        Optional<PessoaJuridica> pessoaJuridica = pessoaJuridicaRepository.findById(id);
        if(pessoaJuridica.isPresent()) {
            pessoaJuridicaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<PessoaJuridicaDto> update(@PathVariable Long id, @Valid @RequestBody RequestPessoaJuridica requestPessoaJuridica, BindingResult result) {

        Optional<PessoaJuridica> optional = pessoaJuridicaRepository.findById(id);

        if(optional.isPresent()) {
            PessoaJuridica pj = requestPessoaJuridica.update(id, pessoaJuridicaRepository);
            return ResponseEntity.ok(new PessoaJuridicaDto(pj));
        }

        return ResponseEntity.notFound().build();

    }

}
