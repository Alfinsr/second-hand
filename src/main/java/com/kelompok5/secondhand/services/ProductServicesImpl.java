package com.kelompok5.secondhand.services;

import com.kelompok5.secondhand.dto.ProductDto;
import com.kelompok5.secondhand.entity.ImageProduct;
import com.kelompok5.secondhand.entity.Product;
import com.kelompok5.secondhand.entity.Users;
import com.kelompok5.secondhand.repository.ImageRepository;
import com.kelompok5.secondhand.repository.ProductRepository;
import com.kelompok5.secondhand.repository.UsersRepository;
import com.kelompok5.secondhand.result.DataResult;
import com.kelompok5.secondhand.result.Result;
import com.kelompok5.secondhand.result.SuccessDataResult;
import com.kelompok5.secondhand.result.SuccessResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.Map;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServicesImpl implements ProductServices {


    @Autowired
    private final UsersRepository usersRepository;
    @Autowired
    private  final ImageRepository imageRepository;

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final CloudinaryStorageService cloudinaryStorageService;

    @Override
    public DataResult<List<Product>> getAllProduct() {
        return new SuccessDataResult<>(productRepository.findAll(), "success get all products");
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Result postProduct(ProductDto body) {
        Optional<Users> optionalUsers = usersRepository.findById(body.getIdUser());

       Product product = new Product();
       product.setNamaProduct(body.getNamaProduct());
       product.setHargaProduct(body.getHargaProduct());
       product.setStatusProduct(body.getStatusProduct());
       product.setDeskripsiProduct(body.getDeskripsiProduct());
       product.setIdKategori(body.getIdKategori());
       product.setUsers(optionalUsers.get());
       productRepository.save(product);


        for (int i=0; i<body.getImageProduct().size();i++){
            Map<?, ?> uploadImage = (Map<?, ?>) cloudinaryStorageService.upload(body.getImageProduct().get(i)).getData();
            ImageProduct imageProduct = new ImageProduct();
            imageProduct.setProduct(product);
            imageProduct.setUrlImage(uploadImage.get("url").toString());
            imageRepository.save(imageProduct);
        }

        return new SuccessDataResult<>("Success post products");
    }

    @Override
    public Result updateProduct(ProductDto body, Integer id) {

        Product product = productRepository.findById(id).orElseThrow();
        product.setNamaProduct(body.getNamaProduct());
        product.setHargaProduct(body.getHargaProduct());
        product.setDeskripsiProduct(body.getDeskripsiProduct());

        product.setIdKategori(body.getIdKategori());

        product.setStatusProduct(body.getStatusProduct());
        productRepository.save(product);

        return new SuccessDataResult<>(body, "Success Update products");

    }

    @Override
    public String deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return "product with "+id+" has been deleted";
    }

//    @Override
//    public List<Product> getProductByUser(String username) {
//        return productRepository.findByusername(username);
//    }

    @Override
    public List<Product> searchProduct(String query) {
        return productRepository.searchProduct(query);
    }


}
