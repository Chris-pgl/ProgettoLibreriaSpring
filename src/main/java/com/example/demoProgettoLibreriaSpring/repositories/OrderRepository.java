package com.example.demoProgettoLibreriaSpring.repositories;

import com.example.demoProgettoLibreriaSpring.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository <Order, Long>{

    Optional<Order> findOrderByClientName (String clientName, String clientSurname);

    Optional<Order> findOrderByClientNumber(String clientNumber);

    Optional<Order> findOrderByClientEmail(String clientEmail);
}
