package com.example.demoProgettoLibreriaSpring.security.securityRepository;

import com.example.demoProgettoLibreriaSpring.security.securityEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

     boolean existsByUsername(String username);
     boolean existsByEmail(String email);
     User findByEmail(String email);

    User getByActivationCode(String activationCode);

    User findByPasswordResetCode(String passwordResetCode);
}
