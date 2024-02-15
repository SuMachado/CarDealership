package com.example.CarDealership.Domain;

import jakarta.persistence.*;

@Entity
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int modelId;
    private String name;

    @OneToMany
     private Brand brand;

    public VehicleModel(int modelId, String name, Brand brand) {
        this.modelId = modelId;
        this.name = name;
        this.brand=brand;
    }

    public int getModelId() {
        return modelId;
    }

    public String getName() {
        return name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }
}
