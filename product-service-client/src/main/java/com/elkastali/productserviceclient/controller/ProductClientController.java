package com.elkastali.productserviceclient.controller;


import com.elkastali.productserviceclient.client.ProductServiceClient;
import com.elkastali.productserviceclient.dto.Product;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-client")
@AllArgsConstructor
public class ProductClientController {

    private ProductServiceClient serviceClient;


    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return  serviceClient.saveProduct(product);
    }

    @GetMapping
    public List<Product> findAll(){
        return  serviceClient.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return serviceClient.findById(id);
    }

    @PutMapping ("/{id}")
    public Product update(@PathVariable Long id,@RequestBody Product product){
        return serviceClient.update(id,product);
    }
    @DeleteMapping("/{id}")
    public Boolean delete(Long id){
        return serviceClient.delete(id);
    }
}
