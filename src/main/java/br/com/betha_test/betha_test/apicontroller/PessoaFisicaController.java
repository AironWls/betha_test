package br.com.betha_test.betha_test.apicontroller;

import br.com.betha_test.betha_test.dto.PessoaFisicaDto;
import br.com.betha_test.betha_test.form.RequestPessoaFisica;
import br.com.betha_test.betha_test.orm.PessoaFisica;
import br.com.betha_test.betha_test.repository.IPessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/pessoafisica")
public class PessoaFisicaController {

    @Autowired
    private IPessoaFisicaRepository pessoaFisicaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<PessoaFisicaDto> store(@Valid @RequestBody RequestPessoaFisica requestPessoaFisica, BindingResult result, UriComponentsBuilder uriBuilder) {
        PessoaFisica pf = requestPessoaFisica.toPessoaFisica();
        pessoaFisicaRepository.save(pf);
        URI uri = uriBuilder.path("/api/pessoafisica/{id}").buildAndExpand(pf.getId()).toUri();
        return ResponseEntity.created(uri).body(new PessoaFisicaDto(pf));
    }

    @GetMapping
    public Page<PessoaFisicaDto> index(@RequestParam(required = false) int pagina, @RequestParam(required = false) int qtd, @RequestParam(required = false) String ordenacao) {
        Pageable paginacao = PageRequest.of(pagina, qtd, Direction.ASC, ordenacao);

        Page<PessoaFisica> pfs = pessoaFisicaRepository.findAll(paginacao);
        return PessoaFisicaDto.converter(pfs);
    }

    @GetMapping("{id}")
    public ResponseEntity<PessoaFisicaDto> show(@PathVariable Long id) {
        Optional<PessoaFisica> pf = pessoaFisicaRepository.findById(id);
        if(pf.isPresent()) {
            return ResponseEntity.ok(new PessoaFisicaDto(pf.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<?> destroy(@PathVariable Long id) {
        Optional<PessoaFisica> pessoaFisica = pessoaFisicaRepository.findById(id);
        if(pessoaFisica.isPresent()) {
            pessoaFisicaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<PessoaFisicaDto> update(@PathVariable Long id, @Valid @RequestBody RequestPessoaFisica requestPessoaFisica, BindingResult result) {

        Optional<PessoaFisica> optional = pessoaFisicaRepository.findById(id);

        if(optional.isPresent()) {
            PessoaFisica pf = requestPessoaFisica.update(id, pessoaFisicaRepository);
            return ResponseEntity.ok(new PessoaFisicaDto(pf));
        }

        return ResponseEntity.notFound().build();

        /*PessoaFisica pf = requestPessoaFisica.update(id, pessoaFisicaRepository);
        pessoaFisicaRepository.save(pf);*/
    }


}
