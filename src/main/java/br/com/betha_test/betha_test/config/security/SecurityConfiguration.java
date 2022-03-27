package br.com.betha_test.betha_test.config.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private AutenticacaoService autenticacaoService;

    //Configuraçoes de autenticacao
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/pessoafisica").permitAll()
                .antMatchers(HttpMethod.GET, "/api/pessoafisica/*").permitAll()
                .antMatchers(HttpMethod.GET, "/api/pessoajuridica").permitAll()
                .antMatchers(HttpMethod.GET, "/api/pessoajuridica/*").permitAll()
                .anyRequest().authenticated()
                .and().formLogin();

//        http.cors().and().csrf().disable().authorizeRequests().antMatchers().permitAll().anyRequest().permitAll();
    }
    //Configuraçoes de autorização
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
    }
    //Configuraçoes de recursos estaticos(js, css, imagens, etc)
    @Override
    public void configure(WebSecurity web) throws Exception {

    }
}
