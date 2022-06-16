package com.kelompok5.secondhand.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
    private String namaProduct;
    private String hargaProduct;
    private String deskripsiProduct;
    private String fotoProduct;
    private String idKategori;
    private String idUser;
    private String statusProduct;

}
