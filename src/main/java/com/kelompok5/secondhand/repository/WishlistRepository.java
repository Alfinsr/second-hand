package com.kelompok5.secondhand.repository;

import com.kelompok5.secondhand.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
}
