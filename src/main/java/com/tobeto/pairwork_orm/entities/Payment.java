package com.tobeto.pairwork_orm.entities;

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
@Table(name = "payments")
public class Payment {
    @Column(name = "payment_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_name", length = 20)
    private EPayment paymentName;

    @OneToOne(mappedBy = "payment", cascade = CascadeType.ALL)
    private Order order;
}
