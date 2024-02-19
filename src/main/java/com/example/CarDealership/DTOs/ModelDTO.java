package com.example.CarDealership.DTOs;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@NoArgsConstructor
@AllArgsConstructor
public class ModelDTO extends RepresentationModel<ModelDTO> {


    private int modelIdDTO;
    private String nameDTO;


     private BrandDTO brandDTO;

     public int getModelIdDTO() {
        return modelIdDTO;
    }

    public String getNameDTO() {
        return nameDTO;
    }

    public BrandDTO getBrandDTO() {
        return brandDTO;
    }

    public void setBrandDTO(BrandDTO brandDTO) {
        this.brandDTO = brandDTO;
    }

    public void setNameDTO(String nameDTO) {
        this.nameDTO = nameDTO;
    }

    public void setModelIdDTO(int modelIdDTO) {
        this.modelIdDTO = modelIdDTO;
    }


}
