package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.entity.Tawaran;
import com.kelompok5.secondhand.repository.TawaranRepository;
import com.kelompok5.secondhand.repository.ProductRepository;
import com.kelompok5.secondhand.repository.UsersRepository;
import com.kelompok5.secondhand.result.Result;
import com.kelompok5.secondhand.result.SuccessDataResult;
import com.kelompok5.secondhand.result.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TawaranServiceImpl implements TawaranServices{

    @Autowired
    private final TawaranRepository tawaranRepository;
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final UsersRepository usersRepository;


    @Override
    public Result saveTawaran(Tawaran body) {
        Tawaran tawaran = new Tawaran();
        tawaran.setUsers(body.getUsers());
        tawaran.setProduct(body.getProduct());
        tawaran.setHargaTawar(body.getHargaTawar());
        tawaran.setStatusTawaran(body.getStatusTawaran());
        tawaranRepository.save(tawaran);

        return new SuccessResult("Success post Tawaran");
    }
    @Override
    public SuccessDataResult findTawaranByIdTawaran(Integer idTawaran){
        Tawaran tawaran = tawaranRepository.findTawaranByIdTawaran(idTawaran);
        return new SuccessDataResult(tawaran, "Success get data tawaran by id");
    }


}
