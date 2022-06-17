package com.kelompok5.secondhand.controllers;

import com.kelompok5.secondhand.dto.ProductDto;
import com.kelompok5.secondhand.entity.Product;
import com.kelompok5.secondhand.services.ProductServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductServices productServices;


    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/Product")
    public ResponseEntity<Product> postProduct(@RequestBody ProductDto ProductDto) {
        Product Product = modelMapper.map(ProductDto, Product.class);
        return new ResponseEntity<>(productServices.postProduct(Product), HttpStatus.CREATED);
    }
    @GetMapping("/Product")
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(productServices.getAllProduct(), HttpStatus.OK);
    }
    @PutMapping("/Product/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDto ProductDto, @PathVariable Integer id){
        Product Product = modelMapper.map(ProductDto, Product.class);
        return new ResponseEntity<>(productServices.updateProduct(Product, id), HttpStatus.ACCEPTED);
    }
}

