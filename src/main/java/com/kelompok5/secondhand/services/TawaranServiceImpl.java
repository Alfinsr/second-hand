package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.dto.TawaranDto;
import com.kelompok5.secondhand.entity.Notifikasi;
import com.kelompok5.secondhand.entity.Product;
import com.kelompok5.secondhand.entity.Tawaran;
import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.repository.NotifikasiRepository;
import com.kelompok5.secondhand.repository.TawaranRepository;
import com.kelompok5.secondhand.repository.ProductRepository;
import com.kelompok5.secondhand.repository.UsersRepository;
import com.kelompok5.secondhand.result.Result;
import com.kelompok5.secondhand.result.SuccessDataResult;
import com.kelompok5.secondhand.result.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TawaranServiceImpl implements TawaranServices{

    @Autowired
    private final TawaranRepository tawaranRepository;
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    private final NotifikasiRepository notifikasiRepository;


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

        Notifikasi notifikasi = new Notifikasi();
        notifikasi.setProduct(product);
        notifikasi.setUsers(users);
        notifikasi.setTawaran(tawaran);
        notifikasi.setTitle("Penawaran Produk");

        notifikasiRepository.save(notifikasi);

        return new SuccessResult("Success post Tawaran");
    }
    @Override
    public Result getTawaranById(Integer idTawaran){
    Tawaran tawaran = tawaranRepository.getById(idTawaran);
        return new SuccessDataResult<>(tawaran, "Success get data tawaran by seller");
    }

    @Override
    public Result getTawaranSeller(String username) {
        Users users = usersRepository.findByUsername(username);
        List<Tawaran> tawarans = tawaranRepository.findByProductUsers(users);
        return new SuccessDataResult<>(tawarans, "Success get tawaran by seller");
    }

    @Override
    public Result getTawaranBuyer(String username) {
        Users users = usersRepository.findByUsername(username);
        List<Tawaran> tawarans = tawaranRepository.findByUsers(users);
        return  new SuccessDataResult<>(tawarans, "Success get tawaran by buyer");
    }

    @Override
    public Result updateTawaran(Integer tawaranId, TawaranDto tawaranDto) {
        Tawaran tawaran = tawaranRepository.getById(tawaranId);
        tawaran.setStatusTawaran(tawaranDto.getStatutsTawaran());
        tawaranRepository.save(tawaran);

        return new SuccessDataResult<>( "Success update status tawaran");
    }
}
