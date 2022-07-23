package com.kelompok5.secondhand.controllers;

import com.kelompok5.secondhand.dto.KategoriDto;
import com.kelompok5.secondhand.entity.Kategori;
import com.kelompok5.secondhand.result.Result;
import com.kelompok5.secondhand.services.KategoriServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequiredArgsConstructor
public class KategoriController {

    @Autowired
    private final KategoriServices kategoriServices;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/kategori")
    public ResponseEntity<Result> postKategori(@RequestBody KategoriDto kategoriDto){
        Kategori kategori = modelMapper.map(kategoriDto, Kategori.class);
       List<Kategori> kategoriList= kategoriServices.getAllKategori();
       if(kategoriList.size() > 4){
           return new ResponseEntity<>(kategoriServices.postKategori(kategori), HttpStatus.INTERNAL_SERVER_ERROR);
       }else{

           return new ResponseEntity<>(kategoriServices.postKategori(kategori), HttpStatus.CREATED);
       }
    }

    @GetMapping("/kategori")
    public ResponseEntity<List<Kategori>> getAllKategori(){
        return new ResponseEntity<>(kategoriServices.getAllKategori(), HttpStatus.OK);
    }



    @GetMapping("/kategori/{id}")
    public ResponseEntity<Optional<Kategori>> getKategoriById(@PathVariable Integer id){
        return new ResponseEntity<>(kategoriServices.getKategoriById(id), HttpStatus.OK);
    }

    @PutMapping("/kategori/{id}")
    public ResponseEntity<Kategori> updateKategori(@RequestBody KategoriDto kategoriDto, @PathVariable Integer id){
        Kategori kategori = modelMapper.map(kategoriDto, Kategori.class);
        return new ResponseEntity<>(kategoriServices.updateKategori(kategori, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/kategori/{id}")
    public ResponseEntity<String> deleteKategori(@PathVariable Integer id){
        return new ResponseEntity<>(kategoriServices.deleteKategori(id), HttpStatus.ACCEPTED);
    }
}
