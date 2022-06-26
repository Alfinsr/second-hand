package com.kelompok5.secondhand.repository;

import com.kelompok5.secondhand.entity.ImageProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageProduct,  Integer> {
}
