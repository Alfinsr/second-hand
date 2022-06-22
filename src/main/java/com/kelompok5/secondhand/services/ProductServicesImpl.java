package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.dto.ProductDto;
import com.kelompok5.secondhand.entity.Product;
import com.kelompok5.secondhand.repository.ProductRepository;
import com.kelompok5.secondhand.result.DataResult;
import com.kelompok5.secondhand.result.Result;
import com.kelompok5.secondhand.result.SuccessDataResult;
import com.kelompok5.secondhand.result.SuccessResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServicesImpl implements ProductServices {


    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final CloudinaryStorageService cloudinaryStorageService;

    @Override
    public DataResult<List<Product>> getAllProduct() {
        return new SuccessDataResult<>(productRepository.findAll(), "success get all products");
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Result postProduct(Product body) {
        productRepository.save(body);

        return new SuccessDataResult<>(body, "Success post products");
    }

    @Override
    public Result updateProduct(Product body, Integer id) {
        System.out.println(id);
        Product product = productRepository.findById(id).orElseThrow();
        product.setNamaProduct(body.getNamaProduct());
        product.setHargaProduct(body.getHargaProduct());
        product.setDeskripsiProduct(body.getDeskripsiProduct());
        product.setFotoProduct(body.getFotoProduct());
        product.setIdKategori(body.getIdKategori());
        product.setIdUser(body.getIdUser());
        product.setStatusProduct(body.getStatusProduct());
        productRepository.save(product);

        return new SuccessDataResult<>(body, "Success Update products");
    }

    @Override
    public String deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return "product with "+id+" has been deleted";
    }
}
