package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.entity.Product;
import com.kelompok5.secondhand.entity.Transaksi;
import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.repository.ProductRepository;
import com.kelompok5.secondhand.repository.TransaksiRepository;
import com.kelompok5.secondhand.repository.UsersRepository;
import com.kelompok5.secondhand.result.Result;
import com.kelompok5.secondhand.result.SuccessDataResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class TransaksiServicesImpl implements TransaksiServices{
    @Autowired
    private final TransaksiRepository transaksiRepository;
    
    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    private final ProductRepository productRepository;


    @Override
    public Result postTransaksi(Transaksi body,String username) {
        Users users = usersRepository.findByUsername(username);
        Product product = productRepository.findById(body.getIdTransaksi()).orElseThrow();

        Transaksi transaksi = new Transaksi();
        transaksi.setProduct(product);
        transaksi.setUsers(users);
        transaksi.setHargaDeal(body.getHargaDeal());
        transaksiRepository.save(transaksi);
        return new SuccessDataResult<>(body,"Success post transaksi");
    }

    @Override
    public Result getTransaksiSeller(String username) {
        Users users = usersRepository.findByUsername(username);
        return new SuccessDataResult<>(transaksiRepository.findByProductUsers(users),"Success get all histori transaksi seller");
    }

    @Override
    public Result getTransaksiBuyer(String username) {
        Users users = usersRepository.findByUsername(username);
        return new SuccessDataResult<>(transaksiRepository.findByUsers(users));
    }
}
