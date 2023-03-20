package com.example.demoProgettoLibreriaSpring.repositories;

import com.example.demoProgettoLibreriaSpring.entities.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {

}
