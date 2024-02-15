package com.example.CarDealership.DTOs;


public class VehicleModelDTO {


    private int modelIdDTO;
    private String DTO;


     private BrandDTO brandDTO;

    public VehicleModelDTO(int modelIdDTO, String DTO, BrandDTO brandDTO) {
        this.modelIdDTO = modelIdDTO;
        this.DTO = DTO;
        this.brandDTO = brandDTO;
    }

    public int getModelIdDTO() {
        return modelIdDTO;
    }

    public String getDTO() {
        return DTO;
    }

    public BrandDTO getBrand() {
        return brandDTO;
    }

    public void setBrand(BrandDTO brandDTO) {
        this.brandDTO = brandDTO;
    }

    public void setDTO(String DTO) {
        this.DTO = DTO;
    }

    public void setModelIdDTO(int modelIdDTO) {
        this.modelIdDTO = modelIdDTO;
    }
}
