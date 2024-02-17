package com.example.CarDealership.Domain;

import com.example.CarDealership.DTOs.ModelDTO;
import jakarta.persistence.*;

@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int modelId;
    private String name;

    @ManyToOne
     private Brand brand;

    public Model(int modelId, String name, Brand brand) {
        this.modelId = modelId;
        this.name = name;
        this.brand=brand;
    }

    public Model() {
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

    public Model buildFromDTO(ModelDTO modelDTO) {
        Model model = new Model();
        model.setModelId(modelDTO.getModelIdDTO());
        model.setName(modelDTO.getNameDTO());
        Brand brand1=new Brand();

        model.setBrand(brand1.buildFromDTO(modelDTO.getBrandDTO()));
        return model;}

    public ModelDTO buildDTO() {
        ModelDTO modelDTO = new ModelDTO();
        modelDTO.setModelIdDTO(this.getModelId());
        modelDTO.setNameDTO(this.getName());
        Brand brand1=new Brand();

        modelDTO.setBrandDTO(brand1.buildDTO());
        return modelDTO;
    }
}
