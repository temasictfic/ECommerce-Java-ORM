package com.tobeto.pairwork_orm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "seller_id", referencedColumnName = "id")
@Table(name="sellers")
public class Seller extends User{

    @Column(name = "company_name")
    private String companyName;
    
    @Column(name = "contact_name")
    private String contactName;
    
    @Column(name = "contact_title")
    private String contactTitle;

    @Column(name = "website")
    private String website;
    
    @Column(name = "tax_number")
    private String taxNumber;

    @ManyToMany(mappedBy = "sellers")
    private List<Product> products;

    @JsonIgnore
    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orders;

}