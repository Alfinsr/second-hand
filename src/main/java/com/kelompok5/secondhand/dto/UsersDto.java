package com.kelompok5.secondhand.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private String fullName;
    private String username;
    private String email;
    private String password;
    private String noWa;
    private MultipartFile profileFoto;
    private String alamat;
    private String kota;
}
