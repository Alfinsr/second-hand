package com.kelompok5.secondhand.repository;

import com.kelompok5.secondhand.entity.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaksiRepository extends JpaRepository<Transaksi, Integer> {
}
