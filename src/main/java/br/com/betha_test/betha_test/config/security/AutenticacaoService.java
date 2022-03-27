package br.com.betha_test.betha_test.config.security;

import br.com.betha_test.betha_test.orm.Pessoa;
import br.com.betha_test.betha_test.repository.IPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private IPessoaRepository pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Pessoa> pessoa = pessoaRepository.findByNome(username);
        if(pessoa.isPresent()) {
            return pessoa.get();
        }
        throw new UsernameNotFoundException("Dados inválidos!");
    }
}
