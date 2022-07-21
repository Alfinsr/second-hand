package com.kelompok5.secondhand.repository;

import com.kelompok5.secondhand.entity.ImageProduct;
import com.kelompok5.secondhand.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageProduct,  Integer> {

    Iterable<ImageProduct> findByProduct(Product product);
}
