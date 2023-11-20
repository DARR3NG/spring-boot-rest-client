package com.elkastali.productservice.controller;

import com.elkastali.productservice.entities.Product;
import com.elkastali.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;



    @GetMapping
    public List<Product>findAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return productService.findById(id);
    }


    @DeleteMapping("/{id}")
    public Boolean deleteById(@PathVariable Long id){
        return productService.delete(id);
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return  productService.create(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id,@RequestBody Product product){
        return  productService.update(id,product);
    }
}
