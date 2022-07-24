package com.kelompok5.secondhand.controllers;

import com.kelompok5.secondhand.dto.TawaranDto;
import com.kelompok5.secondhand.result.Result;
import com.kelompok5.secondhand.services.TawaranServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor

public class TawaranController {
    @Autowired
    private final TawaranServices tawaranService;

    @PostMapping("/tawaran/{idProduct}")
    public ResponseEntity<Result> postTawaran(
            @RequestBody TawaranDto tawaranDto,
            @PathVariable Integer idProduct, Authentication valid){
        String username = valid.getName();
        return new ResponseEntity<>(  tawaranService.saveTawaran(tawaranDto, username,idProduct), HttpStatus.CREATED);

    }

    @GetMapping("/tawaran/{idTawaran}")
    public ResponseEntity<Result> getDetailTawaran(@PathVariable Integer idTawaran) {
        return new ResponseEntity<>(tawaranService.getTawaranById(idTawaran), HttpStatus.OK);
    }

    @GetMapping("/tawaran-seller")
    public ResponseEntity<Result> getTawaranSeller(Authentication authentication){
        return new ResponseEntity<>(tawaranService.getTawaranSeller(authentication.getName()), HttpStatus.OK);
    }

    @GetMapping("/tawaran-buyer")
    public ResponseEntity<Result> getTawaranBuyer(Authentication authentication){
        return new ResponseEntity<>(tawaranService.getTawaranBuyer(authentication.getName()), HttpStatus.OK);
    }

    @CrossOrigin("*")
    @PutMapping("/tawaran/{id}")
    public ResponseEntity<Result> updateStatusTawaran(@PathVariable Integer id, @RequestBody TawaranDto tawaranDto){
        return new ResponseEntity<>(tawaranService.updateTawaran(id,tawaranDto), HttpStatus.ACCEPTED);
    }



}
