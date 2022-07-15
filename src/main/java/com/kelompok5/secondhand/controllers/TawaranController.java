package com.kelompok5.secondhand.controllers;

import com.kelompok5.secondhand.dto.TawaranDto;
import com.kelompok5.secondhand.entity.Product;
import com.kelompok5.secondhand.entity.Tawaran;
import com.kelompok5.secondhand.entity.Users;
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

    @Autowired
    private final UsersServices usersServices;

    @Autowired
    private final ProductServices productServices;

    @PostMapping("/tawaran/{idProduct}")
    public ResponseEntity<?> saveTawaran(
            @RequestBody TawaranDto tawaranDto,
            @PathVariable Integer idProduct, Authentication valid){
        Product product = productServices.findProductById(idProduct);
        String username = valid.getName();
        Users users = usersServices.findByUsername(username);
        Tawaran tawaran = new Tawaran();
        tawaran.setUsers(users);
        tawaran.setProduct(product);
        tawaran.setHargaTawar(tawaranDto.getHargaTawaran());
        tawaran.setStatusTawaran(tawaranDto.getStatutsTawaran());
        tawaranService.saveTawaran(tawaran);
        return new ResponseEntity<>("Behasil Menawar !", HttpStatus.OK);

    }

    @GetMapping("/tawaran/{idTawaran}")
    public ResponseEntity<SuccessDataResult> showTawaran(@PathVariable Integer idTawaran) {
        return new ResponseEntity<>(tawaranService.findTawaranByIdTawaran(idTawaran), HttpStatus.OK);
    }




}
