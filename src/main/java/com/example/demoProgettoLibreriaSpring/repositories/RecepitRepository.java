package com.example.demoProgettoLibreriaSpring.repositories;

import com.example.demoProgettoLibreriaSpring.entities.Recepit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecepitRepository extends JpaRepository<Recepit, Long> {
}
