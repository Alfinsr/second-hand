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
        Optional<Product> optionalProduct = productRepository.findById(wishlist.getIdProduct());
        Wishlist wishlist1 = new Wishlist();
        wishlist1.setUsers(users);
        wishlist1.setProduct(optionalProduct.get());
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
        Wishlist wishlist = wishlistRepository.findById(wishlistId).orElseThrow();
        if(wishlist.getWishlistId() !=null){
            wishlistRepository.deleteById(wishlistId);
            return new SuccessDataResult<>("Success delete wishlist");
        }else{
            return new ErrorDataResult<>("Fail when delete wishlist");
        }
    }
}
