package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.entity.Notifikasi;
import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.repository.NotifikasiRepository;
import com.kelompok5.secondhand.repository.ProductRepository;
import com.kelompok5.secondhand.repository.UsersRepository;
import com.kelompok5.secondhand.result.Result;
import com.kelompok5.secondhand.result.SuccessDataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotifikasiServicesImpl implements NotifikasiServices {

    @Autowired
    private final NotifikasiRepository notifikasiRepository;

    @Autowired
    private final UsersRepository usersRepository;


    @Override
    public Result getNotifikasi(String username) {
        Users users = usersRepository.findByUsername(username);
        List<Notifikasi> notifikasiList = notifikasiRepository.findByProductUsers(users);

        return new SuccessDataResult<>(notifikasiList,"Success get all notifikasi");
    }
}
