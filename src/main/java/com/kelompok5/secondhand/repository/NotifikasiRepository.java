package com.kelompok5.secondhand.repository;

import com.kelompok5.secondhand.entity.Notifikasi;

import com.kelompok5.secondhand.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotifikasiRepository extends JpaRepository<Notifikasi, Integer> {

    List<Notifikasi> findByProductUsers(Users users);
}
