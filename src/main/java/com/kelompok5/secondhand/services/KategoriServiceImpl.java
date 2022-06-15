package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.entity.Kategori;
import com.kelompok5.secondhand.repository.KategoriRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KategoriServiceImpl implements KategoriServices{

    @Autowired
    private final KategoriRepository kategoriRepository;
    @Override
    public List<Kategori> getAllKategori() {
        return kategoriRepository.findAll();
    }

    @Override
    public Kategori postKategori(Kategori body) {
        kategoriRepository.save(body);
        return body;
    }

    @Override
    public Optional<Kategori> getKategoriById(Integer id) {
        return kategoriRepository.findById(id);
    }

    @Override
    public Kategori updateKategori(Kategori body, Integer id) {
        Kategori kategori = kategoriRepository.findById(id).orElseThrow();
        kategori.setNamaKategori(body.getNamaKategori());
        return kategoriRepository.save(kategori);
    }

    @Override
    public String deleteKategori(Integer id) {
        kategoriRepository.deleteById(id);
        return "Kategori with "+id+" has been deleted";
    }
}
