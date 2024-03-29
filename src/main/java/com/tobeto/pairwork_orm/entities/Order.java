package com.tobeto.pairwork_orm.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
public class Order {
    @Column(name="order_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="order_date")
    private LocalDate date;

    @Column(name="shipped_date")
    private LocalDate shippedDate;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="seller_id")
    private Seller seller;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name="shipping_address_id")
    private ShippingAddress shippingAddress;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "order_products",
            joinColumns = { @JoinColumn(name = "order_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
    private List<Product> products;
}
