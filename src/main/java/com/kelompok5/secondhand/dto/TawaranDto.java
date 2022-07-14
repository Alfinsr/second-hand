package com.kelompok5.secondhand.dto;

import com.kelompok5.secondhand.utils.StatutsTawaranEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TawaranDto {
    private String hargaTawaran;
    private Integer idUser;
    private Integer idProduct;
    private StatutsTawaranEnum statutsTawaran;
}
