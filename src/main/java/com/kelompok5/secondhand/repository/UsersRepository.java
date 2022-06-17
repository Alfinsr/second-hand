package com.kelompok5.secondhand.repository;

import com.kelompok5.secondhand.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
