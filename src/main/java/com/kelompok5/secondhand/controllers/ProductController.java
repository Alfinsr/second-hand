package com.kelompok5.secondhand.controllers;

import com.kelompok5.secondhand.dto.ProductDto;
import com.kelompok5.secondhand.entity.Product;
import com.kelompok5.secondhand.result.DataResult;
import com.kelompok5.secondhand.result.Result;
import com.kelompok5.secondhand.services.CloudinaryStorageService;
import com.kelompok5.secondhand.services.CloudinaryStorageServiceImpl;
import com.kelompok5.secondhand.services.ProductServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController @RequiredArgsConstructor

public class ProductController {

    @Autowired
    private final ProductServices productServices;

    @Autowired
    private final CloudinaryStorageService cloudinaryStorageService;


    @Autowired
    ModelMapper modelMapper;

    @PostMapping(value = "/Product",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Result> postProduct(ProductDto productDto) {

        return new ResponseEntity<>(productServices.postProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping("/Product")
    public ResponseEntity<DataResult<List<Product>>> getAllProduct() {
        return new ResponseEntity<>(productServices.getAllProduct(), HttpStatus.OK);

    }

    @GetMapping("/Product/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Integer id) {
        return new ResponseEntity<>(productServices.getProductById(id), HttpStatus.OK);
    }

//    @GetMapping("/product-user")
//    public ResponseEntity<List<Product>> getProductByUser(Authentication authentication){
//        return new ResponseEntity<>(productServices.getProductByUser(authentication.getName()), HttpStatus.OK);
//
//    }

    @PutMapping(value = "/Product/{id}",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Result> updateProduct(ProductDto productDto, @PathVariable Integer id) {


        return new ResponseEntity<>(productServices.updateProduct(productDto, id), HttpStatus.ACCEPTED);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam("query") String query){
        return ResponseEntity.ok(productServices.searchProduct(query));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
        return new ResponseEntity<>(productServices.deleteProduct(id), HttpStatus.ACCEPTED);
    }
}

