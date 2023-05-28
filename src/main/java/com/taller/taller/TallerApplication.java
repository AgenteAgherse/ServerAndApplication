package com.taller.taller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TallerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TallerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}


}
