package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.entity.Wishlist;
import com.kelompok5.secondhand.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistServiceImpl implements WishlistServices{

    @Autowired
    private WishlistRepository wishlistRepository;

    @Override
    public Wishlist postWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    @Override
    public List<Wishlist> getAllWishlist() {

        return wishlistRepository.findAll();
    }

    @Override
    public Wishlist getWishlistById(Integer wishlist_id) {
        return wishlistRepository.findById(wishlist_id).orElseThrow();
    }

    @Override
    public Wishlist updateWishlist(Wishlist wishlist) {
        if(wishlistRepository.findById(wishlist.getWishlist_id()).isPresent()){
            return wishlistRepository.save(wishlist);
        }else {
            return new Wishlist();
        }
    }

    @Override
    public Wishlist deleteWishlist(Integer wishlistId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElseThrow();
        if(wishlistId.getWishlist_id() !=null){
            wishlistRepository.deleteById(wishlistId);
            return wishlistId;
        }else{
            return new Wishlist();
        }
    }
}
