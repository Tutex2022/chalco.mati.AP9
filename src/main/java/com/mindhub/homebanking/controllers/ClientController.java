package com.mindhub.homebanking.controllers;

import com.mindhub.homebanking.dtos.ClientDTO;
import com.mindhub.homebanking.models.Client;
import com.mindhub.homebanking.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<ClientDTO> getClients(){
        List<Client> allClients = clientRepository.findAll();

        //funcion map()
        List<ClientDTO> convertedList = allClients
                                           .stream()
                                           .map(currentClient -> new ClientDTO(currentClient))
                                           .collect(Collectors.toList());

        //ClientDTO clientDTO = new ClientDTO(allClients.get(0));

        return convertedList;
    }
    @GetMapping("/client/{Id}")
    public ClientDTO getClientById(@PathVariable Long Id){
        Optional<Client> clientOptional = clientRepository.findById(Id);
        return new ClientDTO(clientOptional.get());

    }
}
