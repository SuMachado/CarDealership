package com.example.CarDealership.DTOs;


import org.springframework.hateoas.RepresentationModel;

public class BrandDTO  extends RepresentationModel<BrandDTO> {


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
