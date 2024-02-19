package com.example.CarDealership.DTOs;


import org.springframework.hateoas.RepresentationModel;

public class SellerDTO  extends RepresentationModel<SellerDTO> {

    private int sellerIdDTO;

    private String nameDTO;

    private String addressDTO;

    private String taxNumberDTO;

    private String phoneNumberDTO;

    private String emailDTO;
//
//    public SellerDTO(int sellerIdDTO, String nameDTO, String addressDTO, String taxNumberDTO, String phoneNumberDTO, String emailDTO) {
//        this.sellerIdDTO = sellerIdDTO;
//        this.nameDTO = nameDTO;
//        this.addressDTO = addressDTO;
//        this.taxNumberDTO = taxNumberDTO;
//        this.phoneNumberDTO = phoneNumberDTO;
//        this.emailDTO = emailDTO;
//    }

    public SellerDTO() {
    }

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
