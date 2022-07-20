package com.kelompok5.secondhand.repository;


import com.kelompok5.secondhand.entity.Transaksi;
import com.kelompok5.secondhand.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransaksiRepository extends JpaRepository<Transaksi, Integer> {

    List<Transaksi> findByProductUsers(Users users);

    List<Transaksi> findByUsers(Users users);
}
