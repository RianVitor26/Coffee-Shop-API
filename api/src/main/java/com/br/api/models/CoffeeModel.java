package com.br.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Table(name = CoffeeModel.TABLE_NAME)
@Entity
public class CoffeeModel {
    public static final String TABLE_NAME = "Coffee";

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", unique = true)
    private Long id;

    @Size(min = 2, max = 100)
    @NotBlank
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String price;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String amount;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String origin;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String intensity;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String flavor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }
    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

}
