package com.kelompok5.secondhand.dto;

import com.kelompok5.secondhand.utils.StatusProductEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
    private String namaProduct;
    private Integer hargaProduct;
    private String deskripsiProduct;
    private Integer idKategori;
    private Integer idUser;
    private List<MultipartFile> imageProduct;
    private StatusProductEnum statusProduct;

}
