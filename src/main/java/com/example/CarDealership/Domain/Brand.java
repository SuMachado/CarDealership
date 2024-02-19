package com.example.CarDealership.Domain;

import com.example.CarDealership.DTOs.BrandDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int brandId;
    private String name;


    public Brand() {
    }

    public int getBrandId() {
        return brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public Brand buildFromDTO(BrandDTO brandDTO) {
        Brand brand = new Brand();
        if (brandDTO != null) {
            brand.setBrandId(brandDTO.getBrandIdDTO());
            brand.setName(brandDTO.getNameDTO());

        }
        return brand;
    }

    public BrandDTO buildDTO() {
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setBrandIdDTO(this.getBrandId());
        brandDTO.setNameDTO(this.getName());
        return brandDTO;
    }

}
