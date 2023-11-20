package com.elkastali.productserviceclient.client;

import com.elkastali.productserviceclient.dto.Product;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service

public class ProductServiceClient {
    private final RestClient restClient;

    public ProductServiceClient() {
        restClient =RestClient.builder()
                .baseUrl("http://localhost:8080")
                .build();

    }


    public Product saveProduct(Product product){
        return  restClient.post()
                .uri("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .body(product)
                .retrieve()
                .body(Product.class);
    }

    public List<Product>findAll(){
        return   restClient.get()
                .uri("/products")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Product>>() {});
    }

    public Product findById(Long id){
        return restClient.get()
                .uri("/products/{id}",id)
                .retrieve()
                .body(Product.class);
    }

    public Product update(Long id,Product product){
        return restClient
                .put()
                .uri("/products/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(product)
                .retrieve()
                .body(Product.class);
    }

    public Boolean delete(Long id){
        return restClient.delete()
                .uri("/products/{id}",id)
                .retrieve()
                .body(Boolean.class);
    }






}
