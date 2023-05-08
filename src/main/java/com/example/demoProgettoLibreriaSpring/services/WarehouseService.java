package com.example.demoProgettoLibreriaSpring.services;

import com.example.demoProgettoLibreriaSpring.DTO.LoadWarehouseDTO;
import com.example.demoProgettoLibreriaSpring.entities.Book;
import com.example.demoProgettoLibreriaSpring.entities.Inventory;
import com.example.demoProgettoLibreriaSpring.entities.Warehouse;
import com.example.demoProgettoLibreriaSpring.repositories.BookRepository;
import com.example.demoProgettoLibreriaSpring.repositories.InventoryRepository;
import com.example.demoProgettoLibreriaSpring.repositories.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WarehouseService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    @Autowired
    BookRepository bookRepository;

    public Inventory loadBooks(LoadWarehouseDTO loadWarehouseDTO) throws Exception {
        // esiste un inventario?
        if (inventoryRepository.existsByBookIdAndWarehouseId(loadWarehouseDTO.getBookId(), loadWarehouseDTO.getWarehouseId())) {
            // se esiste lo aggiorno
            Inventory inventory = inventoryRepository.findByBookIdAndWarehouseId(loadWarehouseDTO.getBookId(), loadWarehouseDTO.getWarehouseId());
            inventory.setNumOfCopies(inventory.getNumOfCopies() + loadWarehouseDTO.getNumOfCopies());
            return inventoryRepository.save(inventory);
        } else { // se non esiste lo creo
            Optional<Book> optionalBook = bookRepository.findById(loadWarehouseDTO.getBookId());
            if (optionalBook.isEmpty()) throw new Exception("Book " + loadWarehouseDTO.getBookId() + " not found");
            Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(loadWarehouseDTO.getWarehouseId());
            if (optionalWarehouse.isEmpty()) throw new Exception("Warehouse " + loadWarehouseDTO.getWarehouseId() + " not found");
            Inventory inventory = new Inventory();
            inventory.setBook(optionalBook.get());
            inventory.setWarehouse(optionalWarehouse.get());
            inventory.setNumOfCopies(loadWarehouseDTO.getNumOfCopies());
            return inventoryRepository.save(inventory);
        }
    }

}