package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.entity.Transaksi;
import com.kelompok5.secondhand.result.Result;
import org.springframework.stereotype.Component;

@Component
public interface TransaksiServices {
    Result postTransaksi(Transaksi body);
    Result getTransaksiSeller(String username);
    Result getTransaksiBuyer(String username);
}
