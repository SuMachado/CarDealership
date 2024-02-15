package com.example.CarDealership.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int brandId;
    private String name;

    public Brand(int brandId, String name) {
        this.brandId = brandId;
        this.name = name;
    }

    public int getBrandId() {
        return brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }
}
