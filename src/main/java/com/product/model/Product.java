package com.product.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String brand;
    private double price;
    private String color;
    private String size;
    private String sku;

    @ManyToOne(targetEntity = Seller.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "sellerId")
    private Long seller_id;
}
