package com.kelompok5.secondhand.repository;

import com.kelompok5.secondhand.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
