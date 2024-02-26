package com.example.CarDealership.DTOs;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@NoArgsConstructor
@AllArgsConstructor
public class ModelDTO extends RepresentationModel<ModelDTO> {


    private int modelId;
    private String name;


     private BrandDTO brand;

     public int getModelId() {
        return modelId;
    }

    public String getName() {
        return name;
    }

    public BrandDTO getBrand() {
        return brand;
    }

    public void setBrand(BrandDTO brand) {
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }


}
