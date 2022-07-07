package com.kelompok5.secondhand.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class WishlistDto {
    private Integer idProduct;
    private Integer idUser;
}
