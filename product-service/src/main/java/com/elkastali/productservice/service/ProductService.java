package com.elkastali.productservice.service;

import com.elkastali.productservice.dao.IDao;
import com.elkastali.productservice.entities.Product;
import com.elkastali.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService implements IDao<Product> {


    private ProductRepository productRepository;

    @Override
    public Product create(Product o) {
        return productRepository.save(o);
    }

    @Override
    public Product update(Long id,Product o) {
        Product p=findById(id);
        p.setName(o.getName());
        p.setDescription(o.getDescription());
        p.setPrice(o.getPrice());
        p.setProductType(o.getProductType());
        return productRepository.save(p);
    }

    @Override
    public Boolean delete(Long id) {
        try{
            productRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
