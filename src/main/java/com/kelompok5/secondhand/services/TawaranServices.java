package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.dto.TawaranDto;
import com.kelompok5.secondhand.entity.Tawaran;
import com.kelompok5.secondhand.result.Result;
import com.kelompok5.secondhand.result.SuccessDataResult;

public interface TawaranServices {
    Result saveTawaran(TawaranDto tawaranDto, String username, Integer productId);
    Result getTawaranById(Integer idTawaran);

    Result getTawaranSeller(String username);

    Result getTawaranBuyer(String username);
}
