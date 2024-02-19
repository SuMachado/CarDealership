package com.example.CarDealership.DTOs;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@NoArgsConstructor
@AllArgsConstructor
public class BrandDTO  extends RepresentationModel<BrandDTO> {


    private int brandIdDTO;
    private String nameDTO;


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
