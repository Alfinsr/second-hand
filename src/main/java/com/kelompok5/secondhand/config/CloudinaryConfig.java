package com.kelompok5.secondhand.config;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.kelompok5.secondhand.services.CloudinaryStorageService;
import com.kelompok5.secondhand.services.CloudinaryStorageServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinaryAccount(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name","dk4dgvu4w",
                "api_key","312482332544282",
                "api_secret","1oSO-d9c8he7Z7Lb9CjTNjPFMmk"
        ));
    }

    @Bean
    public CloudinaryStorageService cloudinaryStorageService(){
        return new CloudinaryStorageServiceImpl(cloudinaryAccount());
    }


}
