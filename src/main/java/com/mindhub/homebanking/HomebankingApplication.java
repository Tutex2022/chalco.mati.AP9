package com.mindhub.homebanking;

import com.mindhub.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.models.Account;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.AccountRepository;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class HomebankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomebankingApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(ClientRepository clientRepository, AccountRepository accountRepository){
		return(args) -> {
			Client client1 = new Client("Melba","Morel","morel@gmail.com");
			Client client2 = new Client("Matias","Chalco","matias@gmail.com");
			clientRepository.save(client1);
			clientRepository.save(client2);

			Account newAccount1 = new Account("VIN001", LocalDate.now(),1.5,client1);
			client1.addAccount(newAccount1);
			Account newAccount2 = new Account("VIN002", LocalDate.now(),2.5,client2);
			client1.addAccount(newAccount2);


			ClientDTO clientDTO = new ClientDTO(client1);

			Account newAccount3 = new Account("VIN003", LocalDate.now(),3.5,client2);
			client2.addAccount(newAccount3);

			accountRepository.save(newAccount1);
			accountRepository.save(newAccount2);
			accountRepository.save(newAccount3);



		};
	}
}
