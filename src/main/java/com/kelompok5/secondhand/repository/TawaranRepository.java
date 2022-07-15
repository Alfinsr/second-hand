package com.kelompok5.secondhand.repository;

import com.kelompok5.secondhand.entity.Tawaran;
import com.kelompok5.secondhand.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TawaranRepository extends JpaRepository<Tawaran, Integer> {
    Tawaran findTawaranByIdTawaran(Integer idTawaran);
    List<Tawaran> findByProductUsers(Users users);

    List<Tawaran> findByUsers(Users users);
}
