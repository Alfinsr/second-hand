package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.dto.WishlistDto;
import com.kelompok5.secondhand.entity.Product;
import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.entity.Wishlist;
import com.kelompok5.secondhand.repository.ProductRepository;
import com.kelompok5.secondhand.repository.UsersRepository;
import com.kelompok5.secondhand.repository.WishlistRepository;
import com.kelompok5.secondhand.result.ErrorDataResult;
import com.kelompok5.secondhand.result.Result;
import com.kelompok5.secondhand.result.SuccessDataResult;
import com.kelompok5.secondhand.result.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistServices{

    @Autowired
    private final UsersRepository usersRepository;
    @Autowired
    private final ProductRepository productRepository;
    @Autowired
    private final WishlistRepository wishlistRepository;

    @Override
    public Wishlist postWishlist(WishlistDto wishlist, String username) {

      Users users = usersRepository.findByUsername(username);
        Product product = productRepository.findById(wishlist.getIdProduct()).orElseThrow();
        Wishlist wishlist1 = new Wishlist();
        wishlist1.setUsers(users);
        wishlist1.setProduct(product);
        return wishlistRepository.save(wishlist1);
    }

    @Override
    public List<Wishlist> getAllWishlist(String username) {
        Users users = usersRepository.findByUsername(username);
        return wishlistRepository.findByUsers(users);
    }

    @Override
    public Optional<Wishlist> getWishlistById(Integer wishlistId) {
        return wishlistRepository.findById(wishlistId);
    }



    @Override
    public Result deleteWishlist(Integer wishlistId) {
       wishlistRepository.deleteWishlist(wishlistId);
       return new SuccessResult("Success Delete Wishlist");
    }
}
