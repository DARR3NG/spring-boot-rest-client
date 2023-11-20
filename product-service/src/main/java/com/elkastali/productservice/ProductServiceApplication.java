package com.elkastali.productservice;

import com.elkastali.productservice.entities.Product;
import com.elkastali.productservice.enums.ProductType;
import com.elkastali.productservice.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }



    @Bean
    CommandLineRunner commandLineRunner(ProductService productService){

       return  args -> {
           List.of(Product.builder()
                           .name("mobile")
                           .description("SAMSAUNG Galaxy A35")
                           .price(9500)
                           .productType("Electronics")
                           .build(),
                   Product.builder()
                           .name("Keyboard")
                           .description("MAC Magic Keyboard")
                           .price(9500)
                           .productType("Electronics")
                           .build(),
                   Product.builder()
                           .name("Books")
                           .description("It Ends With Us")
                           .price(250)
                           .productType("Education")
                           .build(),
                   Product.builder()
                           .name("Remote Control Toys")
                           .description("Wembley Hight speed Mini 1:24 Scale Rechargeable Remote Control car with Lithium Battery")
                           .price(699)
                           .productType("Baby&Kids")
                           .build(),
                   Product.builder()
                           .name("Airpods")
                           .description("Apple Airpods Prod with Magsafe Charging Case")
                           .price(16990)
                           .productType("Electronics")
                           .build()

           ).forEach( p -> productService.create(p));
       };
    }
}
