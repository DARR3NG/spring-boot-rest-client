package com.elkastali.productserviceclient.dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Product {


    private Long id;
    private String name;
    private String description;
    private double price;
    //@Enumerated(EnumType.STRING)
    private String productType;

}
