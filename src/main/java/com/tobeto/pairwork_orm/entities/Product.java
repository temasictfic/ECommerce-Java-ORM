package com.tobeto.pairwork_orm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Table(name="products")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name="product_name", unique = true)
    private String productName;

    @Column(name="package_height")
    private String packageHeight;

    @Column(name="package_width")
    private String packageWidth;

    @Column(name="package_weight")
    private String packageWeight;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="units_in_stock")
    private int unitsInStock;

    @Column(name="description")
    private String description;

    @Column(name="sales")
    private int sales;

    @Column(name="added_date")
    private  LocalDate addedDate;

    @JsonIgnore
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductPhoto> productPhotos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToMany
    @JoinTable(name="product_seller",
            joinColumns = @JoinColumn(name="product_id"),
            inverseJoinColumns = @JoinColumn(name="seller_id"))
    private List<Seller> sellers;

    @OneToMany(mappedBy = "product")
    private List<CartProduct> cartProducts;

}
