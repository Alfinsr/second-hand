package com.kelompok5.secondhand.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransaksiDto {

    private Integer productId;
    private Integer hargaDeal;
    private Integer userId;
}