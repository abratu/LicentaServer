package com.abratu.entities;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity(name = "product_type")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, precision = 11)
    private Integer id;

    @NotBlank
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", nullable = true, length = 255)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
