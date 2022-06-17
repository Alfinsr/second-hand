package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.entity.Product;
import com.kelompok5.secondhand.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServicesImpl implements ProductServices {

    @Autowired
    private final ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
    @Override
    public Product postProduct(Product body) {
        productRepository.save(body);
        return body;
    }
    @Override
    public Product updateProduct(Product body, Integer id) {
        Product Product = productRepository.findById(id).orElseThrow();
        Product.setNamaProduct(body.getNamaProduct());
        return productRepository.save(Product);
    }
}
