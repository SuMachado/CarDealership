package com.example.CarDealership.Domain;

import com.example.CarDealership.DTOs.BrandDTO;
import com.example.CarDealership.DTOs.VehicleModelDTO;
import jakarta.persistence.*;

@Entity
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int modelId;
    private String name;

    @ManyToOne
     private Brand brand;

    public VehicleModel(int modelId, String name, Brand brand) {
        this.modelId = modelId;
        this.name = name;
        this.brand=brand;
    }

    public VehicleModel() {
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

    public VehicleModel buildFromDTO(VehicleModelDTO vehicleModelDTO) {
        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setModelId(vehicleModelDTO.getModelIdDTO());
        vehicleModel.setName(vehicleModelDTO.getNameDTO());
        Brand brand1=new Brand();

        vehicleModel.setBrand(brand1.buildFromDTO(vehicleModelDTO.getBrandDTO()));
        return vehicleModel;}

    public VehicleModelDTO buildDTO() {
        VehicleModelDTO vehicleModelDTO = new VehicleModelDTO();
        vehicleModelDTO.setModelIdDTO(this.getModelId());
        vehicleModelDTO.setNameDTO(this.getName());
        Brand brand1=new Brand();

        vehicleModelDTO.setBrandDTO(brand1.buildDTO());
        return vehicleModelDTO;
    }
}
