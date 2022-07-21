package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.result.Result;
import org.springframework.stereotype.Component;

@Component
public interface NotifikasiServices {
    Result getNotifikasi(String username);
}
