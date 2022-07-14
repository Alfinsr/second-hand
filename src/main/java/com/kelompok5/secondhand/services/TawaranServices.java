package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.entity.Tawaran;
import com.kelompok5.secondhand.result.ResponsTawaran;

public interface TawaranServices {
    void saveTawaran(Tawaran tawaran);
    ResponsTawaran findTawaranByIdTawaran(Integer idTawaran);
}
