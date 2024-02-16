package com.example.CarDealership.DTOs;


public class BrandDTO {


    private int brandIdDTO;
    private String nameDTO;

    public BrandDTO(int brandIdDTO, String nameDTO) {
        this.brandIdDTO = brandIdDTO;
        this.nameDTO = nameDTO;
    }

    public BrandDTO() {
    }
    public int getBrandIdDTO() {
        return brandIdDTO;
    }

    public String getNameDTO() {
        return nameDTO;
    }

    public void setNameDTO(String nameDTO) {
        this.nameDTO = nameDTO;
    }

    public void setBrandIdDTO(int brandIdDTO) {
        this.brandIdDTO = brandIdDTO;
    }
}
