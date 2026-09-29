package com.test.Estoque_CRUD_SpringBoot.service;

import com.test.Estoque_CRUD_SpringBoot.domain.Product;
import com.test.Estoque_CRUD_SpringBoot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product p){
        if(p==null){
            throw new IllegalArgumentException("Produto nao pode ser nulo");
        }
        else{
            return productRepository.save(p);
        }
    }

    public List<Product> listAllProducts(){
        return productRepository.findAll();
    }

    public
}

