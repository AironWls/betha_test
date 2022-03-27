package br.com.betha_test.betha_test.apicontroller;

import br.com.betha_test.betha_test.form.RequestLogin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid RequestLogin requestLogin) {
        System.out.println(requestLogin.getNome());
        System.out.println(requestLogin.getSenha());

        return ResponseEntity.ok().build();
    }

}
