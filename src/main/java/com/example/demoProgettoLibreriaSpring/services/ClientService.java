package com.example.demoProgettoLibreriaSpring.services;

import com.example.demoProgettoLibreriaSpring.DTO.ClientDTO;
import com.example.demoProgettoLibreriaSpring.entities.Client;
import com.example.demoProgettoLibreriaSpring.repositories.ClientRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public List<Client>getClientList(){
        return clientRepository.findAll();
    }


    public void saveCLient(Client client){
        clientRepository.save(client);
    }


    public Client deleteClient(long id){
        clientRepository.deleteById(id);
        return null;
    }



}
