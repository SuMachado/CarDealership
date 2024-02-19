package com.example.CarDealership.Domain;

import com.example.CarDealership.DTOs.SellerDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sellerId;

    private String name;

    private String address;

    private String taxNumber;

    private String phoneNumber;

    private String email;

//    public Seller(int sellerId, String name, String address, String taxNumber, String phoneNumber, String email) {
//        this.sellerId = sellerId;
//        this.name = name;
//        this.address = address;
//        this.taxNumber = taxNumber;
//        this.phoneNumber = phoneNumber;
//        this.email = email;
//    }

    public Seller() {
    }

    public int getSellerId() {
        return sellerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Seller buildFromDTO( SellerDTO dto) {
        Seller seller = new Seller();

        seller.setSellerId(dto.getSellerIdDTO());
        seller.setName(dto.getNameDTO());
        seller.setAddress(dto.getAddressDTO());
        seller.setTaxNumber(dto.getTaxNumberDTO());
        seller.setPhoneNumber(dto.getPhoneNumberDTO());
        seller.setEmail(dto.getEmailDTO());

        return seller;
    }

    public SellerDTO buildDTO() {
        SellerDTO sellerDTO= new SellerDTO();
        sellerDTO.setSellerIdDTO(this.getSellerId());
        sellerDTO.setNameDTO(this.getName());
        sellerDTO.setAddressDTO(this.getAddress());
        sellerDTO.setTaxNumberDTO(this.getTaxNumber());
        sellerDTO.setPhoneNumberDTO(this.getPhoneNumber());
        sellerDTO.setEmailDTO(this.getEmail());

        return sellerDTO;
    }

}
