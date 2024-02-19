package com.example.CarDealership.DTOs;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@NoArgsConstructor
@AllArgsConstructor
public class SellerDTO  extends RepresentationModel<SellerDTO> {

    private int sellerIdDTO;

    private String nameDTO;

    private String addressDTO;

    private String taxNumberDTO;

    private String phoneNumberDTO;

    private String emailDTO;

    public int getSellerIdDTO() {
        return sellerIdDTO;
    }

    public String getNameDTO() {
        return nameDTO;
    }

    public String getAddressDTO() {
        return addressDTO;
    }

    public String getTaxNumberDTO() {
        return taxNumberDTO;
    }

    public String getPhoneNumberDTO() {
        return phoneNumberDTO;
    }

    public String getEmailDTO() {
        return emailDTO;
    }

    public void setSellerIdDTO(int sellerIdDTO) {
        this.sellerIdDTO = sellerIdDTO;
    }

    public void setNameDTO(String nameDTO) {
        this.nameDTO = nameDTO;
    }

    public void setAddressDTO(String addressDTO) {
        this.addressDTO = addressDTO;
    }

    public void setTaxNumberDTO(String taxNumberDTO) {
        this.taxNumberDTO = taxNumberDTO;
    }

    public void setPhoneNumberDTO(String phoneNumberDTO) {
        this.phoneNumberDTO = phoneNumberDTO;
    }

    public void setEmailDTO(String emailDTO) {
        this.emailDTO = emailDTO;
    }
}
