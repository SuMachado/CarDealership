package com.example.CarDealership.DTOs;


import org.springframework.hateoas.RepresentationModel;

public class ModelDTO extends RepresentationModel<ModelDTO> {


    private int modelIdDTO;
    private String nameDTO;


     private BrandDTO brandDTO;
//
//    public ModelDTO(int modelIdDTO, String nameDTO, BrandDTO brandDTO) {
//        this.modelIdDTO = modelIdDTO;
//        this.nameDTO = nameDTO;
//        this.brandDTO = brandDTO;
//    }

    public ModelDTO()

    {
    }

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
