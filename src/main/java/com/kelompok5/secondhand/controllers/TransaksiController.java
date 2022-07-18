package com.kelompok5.secondhand.controllers;


import com.kelompok5.secondhand.dto.TransaksiDto;
import com.kelompok5.secondhand.entity.Transaksi;
import com.kelompok5.secondhand.result.Result;
import com.kelompok5.secondhand.services.TransaksiServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransaksiController {

    @Autowired
    private final TransaksiServices transaksiServices;


    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/transaksi")
    public ResponseEntity<Result> postTransaksi(@RequestBody TransaksiDto transaksiDto){
        Transaksi transaksi =modelMapper.map(transaksiDto, Transaksi.class);

        return new ResponseEntity<>(transaksiServices.postTransaksi(transaksi), HttpStatus.CREATED);

    }

    @GetMapping("/transaksi-seller")
    public ResponseEntity<Result> getTransaksiSeller(Authentication authentication){
        return new ResponseEntity<>(transaksiServices.getTransaksiSeller(authentication.getName()), HttpStatus.OK);
    }

    @GetMapping("/transaksi-buyer")
    public ResponseEntity<Result> getTransaksiBuyer(Authentication authentication){
        return new ResponseEntity<>(transaksiServices.getTransaksiBuyer(authentication.getName()), HttpStatus.OK);
    }
}
