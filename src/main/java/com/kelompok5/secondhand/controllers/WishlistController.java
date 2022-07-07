package com.kelompok5.secondhand.controllers;




import com.kelompok5.secondhand.dto.WishlistDto;
import com.kelompok5.secondhand.entity.Wishlist;
import com.kelompok5.secondhand.services.WishlistServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class WishlistController {

    @Autowired
    private final WishlistServices wishlistServices;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/wishlist")
    public ResponseEntity<Wishlist> postWishlist(@RequestBody WishlistDto wishlistDto){
        Wishlist = modelMapper.map(wishlistDto, Wishlist.class);
        return new ResponseEntity<>(WishlistServices.postWishlist(Wishlist), HttpStatus.CREATED);
    }

    @GetMapping("/wishlist")
    public ResponseEntity<List<Wishlist>> getAllWishlist(){
        return new ResponseEntity<>(WishlistServices.getAllWishlist(), HttpStatus.OK);
    }

    @GetMapping("/wishlist/{id}")
    public ResponseEntity<Optional<Wishlist>> getAllWishlistById(@PathVariable Integer id){
        return new ResponseEntity<>(wishlistServices.getWishlistById(id), HttpStatus.OK);
    }

    @PutMapping("/wishlist/{id}")
    public ResponseEntity<Wishlist> updateWishlist(@RequestBody WishlistDto wishlistDto, @PathVariable Integer id){
        Wishlist wishlist = modelMapper.map(wishlistDto, wishlist.class);
        return new ResponseEntity<>(wishlistServices.updateWishlist(wishlist), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/Wishlist/{id}")
    public ResponseEntity<String> deleteWishlist(@PathVariable Integer id){
        return new ResponseEntity<String>(wishlistServices.deleteWishlist(id), HttpStatus.ACCEPTED);
    }
}
