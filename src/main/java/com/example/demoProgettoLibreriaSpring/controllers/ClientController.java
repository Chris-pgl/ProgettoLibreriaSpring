package com.example.demoProgettoLibreriaSpring.controllers;


import com.example.demoProgettoLibreriaSpring.entities.Client;
import com.example.demoProgettoLibreriaSpring.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("all")
    public List<Client> getAllClient(){
        return clientService.getClientList();
    }

    @PostMapping("/save")
    public void saveClient(@RequestBody Client client){
        clientService.saveCLient(client);
    }

    @DeleteMapping("/delete")
    public void deleteClient(@RequestParam long id){
        clientService.deleteClient(id);
    }





}
