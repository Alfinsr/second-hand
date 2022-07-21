package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.dto.TawaranDto;
import com.kelompok5.secondhand.result.Result;
import com.kelompok5.secondhand.utils.StatutsTawaranEnum;


public interface TawaranServices {
    Result saveTawaran(TawaranDto tawaranDto, String username, Integer productId);
    Result getTawaranById(Integer idTawaran);

    Result getTawaranSeller(String username);

    Result updateTawaran(Integer tawaranId, TawaranDto tawaranDto);

    Result getTawaranBuyer(String username);
}
