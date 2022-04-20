package com.example.ecommerce_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "product_sku")
public class ProductSku {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", columnDefinition = "integer default 0")
    private Integer quantity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

}