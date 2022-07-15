package com.kelompok5.secondhand.repository;

import com.kelompok5.secondhand.entity.Tawaran;
import com.kelompok5.secondhand.result.ResponsTawaran;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TawaranRepository extends JpaRepository<Tawaran, Integer> {
    Tawaran findTawaranByIdTawaran(Integer idTawaran);
}