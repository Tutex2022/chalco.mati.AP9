package com.mindhub.homebanking;

import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
		//Client client1 = new Client("1235678","Lionel","Messi");

		Client client2 = new Client();
		//client2.setDni("98765431");

	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository){
		return(args) ->{
			Client client = new Client("matias@gmail.com","Matias","Chalco");


			//Client client = new Client();

			clientRepository.save(client);
		};
	}
}
