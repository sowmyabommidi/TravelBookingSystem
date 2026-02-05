package com.travel.repository;

import com.travel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // ✅ returns LIST instead of single result
    List<User> findByEmailAndPassword(String email, String password);

	Optional<User> findById(String email);
}
