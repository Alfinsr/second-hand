package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.entity.Tawaran;
import com.kelompok5.secondhand.entity.Product;
import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.repository.TawaranRepository;
import com.kelompok5.secondhand.repository.ProductRepository;
import com.kelompok5.secondhand.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TawaranServiceImpl implements TawaranServices{

    @Autowired
    private TawaranRepository tawaranRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UsersRepository usersRepository;


    @Override
    public void saveTawaran(Tawaran body) {
        Tawaran tawaran = new Tawaran();
        tawaran.setUsers(body.getUsers());
        tawaran.setProduct(body.getProduct());
        tawaran.setHargaTawar(body.getHargaTawar());
        tawaran.setStatusTawaran(body.getStatusTawaran());
        tawaranRepository.save(tawaran);
    }


}
