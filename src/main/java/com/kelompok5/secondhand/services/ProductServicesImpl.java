package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.dto.ProductDto;
import com.kelompok5.secondhand.entity.ImageProduct;
import com.kelompok5.secondhand.entity.Kategori;
import com.kelompok5.secondhand.entity.Product;
import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.repository.ImageRepository;
import com.kelompok5.secondhand.repository.KategoriRepository;
import com.kelompok5.secondhand.repository.ProductRepository;
import com.kelompok5.secondhand.repository.UsersRepository;
import com.kelompok5.secondhand.result.*;
import com.kelompok5.secondhand.utils.StatusProductEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServicesImpl implements ProductServices {


    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    private final KategoriRepository kategoriRepository;
    @Autowired
    private  final ImageRepository imageRepository;

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final CloudinaryStorageService cloudinaryStorageService;

    @Override
    public DataResult<List<Product>> getAllProduct(int pageNo, int pageSize,String kategori, String q) {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        return new SuccessDataResult<>(productRepository.searchProducts( kategori,q, paging), "success get all products");
    }

    @Override
    public DataResult<List<Product>> getAllProductWithLogin(int pageNo, int pageSize, String kategori, String q, String username) {
        Users users = usersRepository.findByUsername(username);
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return new SuccessDataResult<>(productRepository.searchProductsWithLogin(kategori,q, users.getIdUser(),paging),"Success get all product");
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Result postProduct(ProductDto body,String username) {
        Users optionalUsers = usersRepository.findByUsername(username);
        Kategori optionalKategori = kategoriRepository.findById(body.getIdKategori()).orElseThrow();
        List<Product> productList;
        DataResult<List<Product>> listDataResult = getProductByUser(username);
        productList = listDataResult.getData().stream()
                .filter(product -> product.getStatusProduct().equals(StatusProductEnum.PUBLISH))
                .collect(Collectors.toList());
        if (productList.size() > 3 &&  body.getStatusProduct().equals(StatusProductEnum.PUBLISH)){
           return new ErrorResult("Maximum post product is 4");
        }else{
            Product product = new Product();
            product.setNamaProduct(body.getNamaProduct());
            product.setHargaProduct(body.getHargaProduct());
            product.setStatusProduct(body.getStatusProduct());
            product.setDeskripsiProduct(body.getDeskripsiProduct());
            product.setKategori(optionalKategori);
            product.setUsers(optionalUsers);
            productRepository.save(product);



            for (int i=0; i<body.getImageProduct().size();i++){
                Map<?, ?> uploadImage = (Map<?, ?>) cloudinaryStorageService.upload(body.getImageProduct().get(i)).getData();
                ImageProduct imageProduct = new ImageProduct();
                imageProduct.setProduct(product);
                imageProduct.setUrlImage(uploadImage.get("url").toString());
                imageRepository.save(imageProduct);
            }

            return new SuccessResult("Success post products");

        }


    }

    @Override
    public Result updateProduct(ProductDto body, Integer id) {
        Kategori kategori = kategoriRepository.findById(body.getIdKategori()).orElseThrow();
        Product product = productRepository.findById(id).orElseThrow();

        if(body.getImageProduct()== null){

            product.setNamaProduct(body.getNamaProduct());
            product.setHargaProduct(body.getHargaProduct());
            product.setDeskripsiProduct(body.getDeskripsiProduct());
            product.setKategori(kategori);
            product.setStatusProduct(body.getStatusProduct());
            productRepository.save(product);
        }else{

            product.setNamaProduct(body.getNamaProduct());
            product.setHargaProduct(body.getHargaProduct());
            product.setDeskripsiProduct(body.getDeskripsiProduct());
            product.setKategori(kategori);
            product.setStatusProduct(body.getStatusProduct());
            productRepository.save(product);
            Iterable<ImageProduct> imageProduct = imageRepository.findByProduct(product);

            imageRepository.deleteAllInBatch(imageProduct);
            for (int i=0; i<body.getImageProduct().size();i++){
                Map<?, ?> uploadImage = (Map<?, ?>) cloudinaryStorageService.upload(body.getImageProduct().get(i)).getData();
                ImageProduct imageProducts = new ImageProduct();
                imageProducts.setProduct(product);
                imageProducts.setUrlImage(uploadImage.get("url").toString());
                imageRepository.save(imageProducts);
            }


        }



        return new SuccessDataResult<>( "Success Update products");

    }

    @Override
    public Result deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return new SuccessResult("Success Delete Product");
    }

    @Override
    public DataResult<List<Product>> getProductByUser(String username) {
        Users users = usersRepository.findByUsername(username);
       List<Product> products= productRepository.findByusers(users);
        return new SuccessDataResult<>(products, "Sucess Get Product By Users");
    }

    @Override
    public Result updateStatusProduct(Integer id, ProductDto productDto,String username) {
        Product product = productRepository.findById(id).orElseThrow();

        List<Product> productList;
        DataResult<List<Product>> listDataResult = getProductByUser(username);
        productList = listDataResult.getData().stream()
                .filter(products -> products.getStatusProduct().equals(StatusProductEnum.PUBLISH))
                .collect(Collectors.toList());
        if (productList.size() > 3 && productDto.getStatusProduct().equals(StatusProductEnum.PUBLISH)){
            return new ErrorResult("Maximum post product is 4");
        }else{
            product.setStatusProduct(productDto.getStatusProduct());
            productRepository.save(product);
            return new SuccessResult("Success update status product");
        }

    }
}
