package com.kelompok5.secondhand.controllers;


import com.kelompok5.secondhand.result.Result;
import com.kelompok5.secondhand.services.NotifikasiServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NotifikasiController {
    @Autowired
    private final NotifikasiServices notifikasiServices;

    @GetMapping("/notfikasi")
    public ResponseEntity<Result> getAllNotifikasi(Authentication authentication){
        return new ResponseEntity<>(notifikasiServices.getNotifikasi(authentication.getName()), HttpStatus.OK);
    }
}
