package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.entity.Kategori;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface KategoriServices {
    List<Kategori> getAllKategori();
    Kategori postKategori(Kategori body);
    Optional<Kategori> getKategoriById(Integer id);
    Kategori updateKategori(Kategori body, Integer id);
    String deleteKategori(Integer id);

}
