package com.seninha.CrudCadeia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seninha.CrudCadeia.services.WorkServices;

@SpringBootApplication
public class CrudCadeiaApplication implements CommandLineRunner {
	
    @Autowired
    private WorkServices workService;
    
	public static void main(String[] args) {
		SpringApplication.run(CrudCadeiaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		workService.seeAll();
		
	}

}
