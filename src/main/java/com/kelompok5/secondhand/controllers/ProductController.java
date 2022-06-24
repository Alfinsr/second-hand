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
        Map<?, ?> uploadImage = (Map<?, ?>) cloudinaryStorageService.upload(productDto.getFotoProduct()).getData();
       Product product = new Product();
       product.setFotoProduct(uploadImage.get("url").toString());
       product.setDeskripsiProduct(productDto.getDeskripsiProduct());
       product.setHargaProduct(productDto.getHargaProduct());
       product.setNamaProduct(productDto.getNamaProduct());
       product.setIdKategori(productDto.getIdKategori());
       product.setIdUser(productDto.getIdUser());
       product.setStatusProduct(productDto.getStatusProduct());
        return new ResponseEntity<>(productServices.postProduct(product), HttpStatus.CREATED);
    }
    @GetMapping("/Product")
    public ResponseEntity<DataResult<List<Product>>> getAllProduct(){
        return new ResponseEntity<>(productServices.getAllProduct(), HttpStatus.OK);

    }
    @GetMapping("/Product/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Integer id){
        return new ResponseEntity<>(productServices.getProductById(id), HttpStatus.OK);
    }
    @PutMapping(value= "/Product/{id}",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Result> updateProduct(ProductDto productDto, @PathVariable Integer id){

        Map<?, ?> uploadImage = (Map<?, ?>) cloudinaryStorageService.upload(productDto.getFotoProduct()).getData();
        Product product = new Product();
        product.setFotoProduct(uploadImage.get("url").toString());
        product.setDeskripsiProduct(productDto.getDeskripsiProduct());
        product.setHargaProduct(productDto.getHargaProduct());
        product.setNamaProduct(productDto.getNamaProduct());
        product.setIdKategori(productDto.getIdKategori());
        product.setIdUser(productDto.getIdUser());
        product.setStatusProduct(productDto.getStatusProduct());
        return new ResponseEntity<>(productServices.updateProduct(product, id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam("query") String query){
        return ResponseEntity.ok(productServices.searchProduct(query));
    }

}

