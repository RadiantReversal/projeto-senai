package com.senai.projetosenai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.senai.projetosenai")
public class ProjetoSenaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSenaiApplication.class, args);
	}

}
