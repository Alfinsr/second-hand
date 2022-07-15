package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.dto.TawaranDto;
import com.kelompok5.secondhand.entity.Product;
import com.kelompok5.secondhand.entity.Tawaran;
import com.kelompok5.secondhand.entity.Users;
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
    public Result saveTawaran(TawaranDto tawaranDto, String username, Integer productId) {
        Product product = productRepository.findProductByIdProduct(productId);
        Users users = usersRepository.findByUsername(username);
        Tawaran tawaran = new Tawaran();
        tawaran.setUsers(users);
        tawaran.setProduct(product);
        tawaran.setHargaTawar(tawaranDto.getHargaTawaran());
        tawaran.setStatusTawaran(tawaranDto.getStatutsTawaran());


        tawaranRepository.save(tawaran);

        return new SuccessResult("Success post Tawaran");
    }
    @Override
    public SuccessDataResult findTawaranByIdTawaran(Integer idTawaran){
        Tawaran tawaran = tawaranRepository.findTawaranByIdTawaran(idTawaran);
        return new SuccessDataResult(tawaran, "Success get data tawaran by id");
    }


}
