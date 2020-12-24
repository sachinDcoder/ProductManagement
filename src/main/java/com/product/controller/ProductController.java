package com.product.controller;

import com.product.model.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/insert")
    public ResponseEntity insertProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.insertProduct(product), HttpStatus.CREATED);
    }

    @GetMapping(path = "/brands")
    public ResponseEntity<?> getBrands() {
        return new ResponseEntity<>(productService.findBrand(), HttpStatus.OK);
    }

    @GetMapping(path = "/order_by_brands")
    public ResponseEntity<?> getOrderBrands() {
        return new ResponseEntity<>(productService.findOrderBrand(), HttpStatus.OK);
    }

    @GetMapping(path = "/get_by_brands")
    public ResponseEntity<?> getOrderBrands(@RequestParam String brand) {
        return new ResponseEntity<>(productService.findByBrandName(brand), HttpStatus.OK);
    }
}
