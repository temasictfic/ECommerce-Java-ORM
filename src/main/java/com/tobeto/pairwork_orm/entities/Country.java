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
@Table(name="countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int countryId;

    @Column(name = "country_name")
    private String countryName;

    @JsonIgnore
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Region> regions;

    @JsonIgnore
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CustomerAddress> customerAddresses;
}
