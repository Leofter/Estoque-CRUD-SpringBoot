package com.test.Estoque_CRUD_SpringBoot.controller;

import com.test.Estoque_CRUD_SpringBoot.domain.Product;
import com.test.Estoque_CRUD_SpringBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product p){
        return productService.createProduct(p);
    }

    @GetMapping
    public List<Product> listAllProducts(){
        return productService.listAllProducts();
    }

    @PutMapping
    public Product changePrice(){

    }


//    @PostMapping
//    public Product createProduct(@RequestBody Product product){
//        return productRepository.save(product);
//    }
//
//    @GetMapping
//    public List<Product> getAllProducts(){
//        return productRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Product getProductById(@PathVariable Long id){
//        return productRepository.findById(id);
//    }
}
