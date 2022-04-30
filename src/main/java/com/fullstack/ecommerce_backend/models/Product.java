package com.fullstack.ecommerce_backend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="price",nullable = false)
    private Integer price;

    @Column(name="isPublished",columnDefinition = "boolean default false")
    private Boolean isPublish;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private Collection<ProductSku> skus;
}