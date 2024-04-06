package com.tobeto.pairwork_orm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
public class Order {
    @Id
    @Column(name="order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column(name="order_created_date")
    private LocalDate orderCreatedDate;

    @Column(name="order_shipped_date")
    private LocalDate orderShippedDate;

    @Column(name="order_delivered_date")
    private LocalDate orderDeliveredDate;

    @Column(name="order_returned_date")
    private LocalDate orderReturnedDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

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
    @JoinColumn(name="customer_address_id")
    private CustomerAddress customerAddress;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProducts;
}
