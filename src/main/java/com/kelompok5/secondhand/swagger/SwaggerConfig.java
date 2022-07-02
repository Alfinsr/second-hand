package com.kelompok5.secondhand.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2

public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kelompok5.secondhand.controllers"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Api Dokumentasi Penjualan Barang Bekas",
                "Ini adalah dokumentasi API untuk Penjualan Barang Bekas Online",
                "v1.0",
                "Terms of service",
                new Contact("Mohamad Rizal Khamami","www.rizalmohamadtech.id","rizalmohamad209@gmail.com"),
                "Apache License",
                "www.apache.com",
                Collections.emptyList()
        );
    }


}
