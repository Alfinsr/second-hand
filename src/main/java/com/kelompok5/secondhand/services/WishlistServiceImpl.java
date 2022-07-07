package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.entity.Wishlist;
import com.kelompok5.secondhand.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Wishlist> getWishlistById(Integer wishlist_id) {
        return wishlistRepository.findById(wishlist_id);
    }

    @Override
    public Wishlist updateWishlist(Wishlist wishlist) {
        if(wishlistRepository.findById(wishlist.getWishlistId().intValue()).isPresent()){
            return wishlistRepository.save(wishlist);
        }else {
            return new Wishlist();
        }
    }

    @Override
    public String deleteWishlist(Integer wishlistId) {
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElseThrow();
        if(wishlist.getWishlistId() !=null){
            wishlistRepository.deleteById(wishlistId);
            return "sukses";
        }else{
            return "gagal";
        }
    }
}
