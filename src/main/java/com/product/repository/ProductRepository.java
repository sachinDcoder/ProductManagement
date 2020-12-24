package com.product.repository;

import com.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = "select count(product_id), brand from product group by brand")
    Object findBrand();

    @Query(nativeQuery = true, value = "select * from product order by brand")
    List<Product> findOrderByBrand();

    @Query(nativeQuery = true, value = "select * from product p where p.brand =:brand ")
    List<Product> findByBrandName(@Param("brand") String brand);
}
