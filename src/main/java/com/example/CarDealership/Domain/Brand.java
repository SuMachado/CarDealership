package com.example.CarDealership.Domain;

import com.example.CarDealership.DTOs.BrandDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int brandId;
    private String name;


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
            brand.setBrandId(brandDTO.getBrandId());
            brand.setName(brandDTO.getName());

        }
        return brand;
    }

    public BrandDTO buildDTO() {
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setBrandId(this.getBrandId());
        brandDTO.setName(this.getName());
        return brandDTO;
    }

}
