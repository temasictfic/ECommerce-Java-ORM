package com.tobeto.pairwork_orm.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.PastOrPresent;
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

    @PastOrPresent(message = "Sipariş tarihi ileri bir tarih olamaz.")
    @Column(name="order_created_date")
    private LocalDate orderCreatedDate;

    @PastOrPresent(message = "Kargo veriliş tarihi ileri bir tarih olamaz.")
    @Column(name="order_shipped_date")
    private LocalDate orderShippedDate;

    @PastOrPresent(message = "Kargo teslim tarihi ileri bir tarih olamaz.")
    @Column(name="order_delivered_date")
    private LocalDate orderDeliveredDate;

    @Future(message = "Tahmini teslim tarihi ileri bir tarih olmalıdır.")
    @Column(name="estimated_delivery_date")
    private LocalDate estimatedDeliveryDate;

    @PastOrPresent(message = "İade tarihi ileri bir tarih olamaz.")
    @Column(name="order_returned_date")
    private LocalDate orderReturnedDate;

    @Enumerated(EnumType.STRING)
    private EOrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "order")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name="customer_address_id")
    private CustomerAddress customerAddress;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProducts;
}
