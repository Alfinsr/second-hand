package com.kelompok5.secondhand.repository;

import com.kelompok5.secondhand.entity.Product;
import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.entity.Wishlist;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {

    List<Wishlist> findByUsers(Users users);


    @Query("DELETE w FROM wishlist w WHERE wishlistId :idWishlist")
    Wishlist deleteWishlist(Integer idWishlist);
}
