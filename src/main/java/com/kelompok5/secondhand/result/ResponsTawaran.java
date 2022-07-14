package com.kelompok5.secondhand.result;

import com.kelompok5.secondhand.entity.ImageProduct;
import com.kelompok5.secondhand.entity.Tawaran;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class ResponsTawaran {
    Integer idTawaran;
    String fullName;
    String namaProduct;
    Set<ImageProduct> imageProducts;
    String hargaTawar;

    public ResponsTawaran (Tawaran tawaran){
        this.idTawaran = tawaran.getIdTawaran();
        this.fullName = tawaran.getUsers().getFullName();
        this.imageProducts = tawaran.getProduct().getImageProduct();
        this.namaProduct = tawaran.getProduct().getNamaProduct();
        this.hargaTawar = tawaran.getHargaTawar();
    }
}
