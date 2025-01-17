package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.dto.WishlistDto;
import com.kelompok5.secondhand.entity.Wishlist;
import com.kelompok5.secondhand.result.Result;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface WishlistServices {

    List<Wishlist> getAllWishlist(String username);
    Wishlist postWishlist(WishlistDto body, String username);
    Optional<Wishlist> getWishlistById(Integer id);
    Result deleteWishlist(Integer id);

}
