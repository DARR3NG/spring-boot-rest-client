package com.elkastali.productservice.entities;

import com.elkastali.productservice.enums.ProductType;
import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@ToString
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    //@Enumerated(EnumType.STRING)
    private String productType;

}
