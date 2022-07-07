package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.entity.Wishlist;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface WishlistServices {

    List<Wishlist> getAllWishlist();
    Wishlist postWishlist(Wishlist body);
    Optional<Wishlist> getWishlistById(Integer id);

    Wishlist updateWishlist(Wishlist wishlist);

    String deleteWishlist(Integer id);

}
