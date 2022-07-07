package com.kelompok5.secondhand.repository;

import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {

    List<Wishlist> findByUsers(Users users);
}
