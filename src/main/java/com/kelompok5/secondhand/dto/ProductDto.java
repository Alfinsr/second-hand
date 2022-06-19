package com.kelompok5.secondhand.dto;

import com.kelompok5.secondhand.utils.StatusProductEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
    private String namaProduct;
    private Integer hargaProduct;
    private String deskripsiProduct;
    private MultipartFile fotoProduct;
    private Integer idKategori;
    private Integer idUser;
    private StatusProductEnum statusProduct;

}
