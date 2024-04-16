package com.tobeto.pairwork_orm.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "customer_id", referencedColumnName = "id")
@Table(name="customers")
public class Customer extends User{
    @Column(name="birth_date")
    private LocalDate birthDate;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @OneToOne(mappedBy = "customer")
    private Cart cart;

}
