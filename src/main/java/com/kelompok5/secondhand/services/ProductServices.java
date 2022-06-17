package com.kelompok5.secondhand.services;


import com.kelompok5.secondhand.entity.Product;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public interface ProductServices {
    List<Product> getAllProduct();
    Product postProduct(Product body);
    Product updateProduct(Product body, Integer id);
    }
