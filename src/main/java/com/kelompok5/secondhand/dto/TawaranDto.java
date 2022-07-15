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
    private Integer hargaTawaran;
    private StatutsTawaranEnum statutsTawaran;
}
