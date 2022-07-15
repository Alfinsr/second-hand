package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.entity.Tawaran;
import com.kelompok5.secondhand.result.Result;
import com.kelompok5.secondhand.result.SuccessDataResult;

public interface TawaranServices {
    Result saveTawaran(Tawaran tawaran);
    SuccessDataResult findTawaranByIdTawaran(Integer idTawaran);
}
