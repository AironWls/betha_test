package br.com.betha_test.betha_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class BethaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BethaTestApplication.class, args);
	}

}
