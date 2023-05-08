package com.example.demoProgettoLibreriaSpring.controllers;

import com.example.demoProgettoLibreriaSpring.DTO.LoadWarehouseDTO;
import com.example.demoProgettoLibreriaSpring.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;

    @PostMapping("/load-books")
    public ResponseEntity loadBooks(@RequestBody LoadWarehouseDTO loadDTO) {
        // cerco l'inventario di questo libro in questo magazzino;
        // se c'è lo aggiorno, se non c'è lo creo
        try {
            return ResponseEntity.ok(warehouseService.loadBooks(loadDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/sell-book")
    public ResponseEntity sellBook() {
        /*
        TODO
        creare un service che:
        1. cerca l'inventario di questo libro e:
            1.1 se non lo trova o se l'inventario è vuoto -> errore
            1.2 se lo trova scala il numero totale di copie
        2. produce uno scontrino
         */
        return ResponseEntity.ok("todo");
    }

}
