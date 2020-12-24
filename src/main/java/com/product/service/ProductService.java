package com.product.service;

import com.product.model.Product;
import com.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    public Object findBrand() {
        return productRepository.findBrand();
    }

    public List<Product> findOrderBrand() {
        return productRepository.findOrderByBrand();
    }

    public List<Product> findByBrandName(String brand) {
        return productRepository.findByBrandName(brand);
    }
}
