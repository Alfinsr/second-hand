package com.kelompok5.secondhand.repository;

import com.kelompok5.secondhand.entity.Product;
import com.kelompok5.secondhand.entity.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    @Query("SELECT p FROM product p WHERE " +
            "p.namaProduct LIKE CONCAT('%',:query, '%')" +
            "Or p.deskripsiProduct LIKE CONCAT('%',:query, '%')")
    List<Product> searchProduct(String query);

    @Query("SELECT p FROM product p INNER JOIN p.kategori k where  k.namaKategori like CONCAT('%',:kategoris,'%')  AND p.namaProduct like CONCAT ('%',:search,'%')")
    List<Product> searchProducts(String kategoris, String search, Pageable pageable);

    List<Product> findByusers(Users users);
}
