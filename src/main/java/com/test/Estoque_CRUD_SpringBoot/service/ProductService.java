package com.test.Estoque_CRUD_SpringBoot.service;

import com.test.Estoque_CRUD_SpringBoot.domain.Product;
import com.test.Estoque_CRUD_SpringBoot.mapper.ProductMapper;
import com.test.Estoque_CRUD_SpringBoot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product){
        if(product==null){
            throw new IllegalArgumentException("Produto nao pode ser nulo");
        }
        return productRepository.save(product);
    }

    public List<Product> listAllProducts(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id).get();
    }

//    public Product updateProduct(Long id, Product newProduct){
//        Product oldProduct = findById(id);
//        oldProduct.setName(newProduct.getName());
//        oldProduct.setDescription(newProduct.getDescription());
//        oldProduct.setAmount(newProduct.getAmount());
//        oldProduct.setPrice(newProduct.getPrice());
//        oldProduct.setLastUpdate(newProduct.getLastUpdate());
//        return productRepository.save(oldProduct);
//    }

    public Product updateProduct(Long id, Product newProduct){
        Product oldProduct = findById(id);
        productMapper.maperProduct(newProduct, oldProduct);
        return productRepository.save(oldProduct);
    }


}

