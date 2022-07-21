package com.kelompok5.secondhand.services;


import com.kelompok5.secondhand.dto.ProductDto;
import com.kelompok5.secondhand.entity.Product;
import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.result.DataResult;
import com.kelompok5.secondhand.result.Result;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public interface ProductServices {
    DataResult<List<Product>> getAllProduct(int pageNo, int pageSize,String kategori, String q);
    DataResult<List<Product>> getAllProductWithLogin(int pageNo, int pageSize,String kategori, String q,String username);


    Result postProduct(ProductDto body, String username);
    Optional<Product>getProductById(Integer id);
    Result updateProduct(ProductDto body, Integer id);

    Result deleteProduct(Integer id);
    DataResult<List<Product>>  getProductByUser(String username);
    Product findProductById(Integer idProduct);

}