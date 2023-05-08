package com.example.demoProgettoLibreriaSpring.repositories;

import com.example.demoProgettoLibreriaSpring.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    boolean existsByBookIdAndWarehouseId(long bookId, long warehouseId);

    Inventory findByBookIdAndWarehouseId(long bookId, long warehouseId);

}
