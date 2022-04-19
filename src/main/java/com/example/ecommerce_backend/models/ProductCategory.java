package com.example.ecommerce_backend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "product_category")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="parent_id")
    private ProductCategory parent;

    @OneToMany(mappedBy = "parent")
    private Collection<ProductCategory> children;

    @OneToMany(mappedBy = "category")
    private Collection<Product> products;
}