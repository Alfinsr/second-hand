package com.kelompok5.secondhand.controllers;

import com.kelompok5.secondhand.dto.TawaranDto;
import com.kelompok5.secondhand.entity.Product;
import com.kelompok5.secondhand.entity.Tawaran;
import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.result.Result;
import com.kelompok5.secondhand.result.SuccessDataResult;
import com.kelompok5.secondhand.services.ProductServices;
import com.kelompok5.secondhand.services.TawaranServices;
import com.kelompok5.secondhand.services.UsersServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
    public ResponseEntity<Result> saveTawaran(
            @RequestBody TawaranDto tawaranDto,
            @PathVariable Integer idProduct, Authentication valid){
        String username = valid.getName();
        return new ResponseEntity<>(  tawaranService.saveTawaran(tawaranDto, username,idProduct), HttpStatus.CREATED);

    }

    @GetMapping("/tawaran/{idTawaran}")
    public ResponseEntity<SuccessDataResult> showTawaran(@PathVariable Integer idTawaran) {
        return new ResponseEntity<>(tawaranService.findTawaranByIdTawaran(idTawaran), HttpStatus.OK);
    }

}
