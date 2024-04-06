package com.tobeto.pairwork_orm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customer_addresses")
public class CustomerAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_address_id")
    private int customerAddressId;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "postal_code")
    private String postal_code;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @JsonIgnore
    @OneToMany(mappedBy = "customerAddress", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orders;

}
