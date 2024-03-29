package com.tobeto.pairwork_orm.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="products")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Column(name="product_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="package_height")
    private String packageHeight;

    @Column(name="package_width")
    private String packageWidth;

    @Column(name="package_weight")
    private String packageWeight;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_photo_url")
    private String productPhotoUrl;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="unit_in_stock")
    private int unitInStock;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductPhoto> productPhotos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToMany(mappedBy = "products")
    private List<Cart> carts;

    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    @ManyToMany(mappedBy = "products")
    private List<Seller> sellers;

}
