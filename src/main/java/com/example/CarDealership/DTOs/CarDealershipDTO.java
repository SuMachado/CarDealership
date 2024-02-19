package com.example.CarDealership.DTOs;

import org.springframework.hateoas.RepresentationModel;

import java.util.ArrayList;
import java.util.List;


public class CarDealershipDTO extends RepresentationModel<CarDealershipDTO> {


    private int dealerIDDTO;

    private String nameDTO;

    private String addressDTO;
    private String phoneNumberDTO;
    private double finalBalanceDTO;

    private List<VehicleDTO> vehicleDTOS;
//
//    public CarDealershipDTO(int dealerIDDTO, String nameDTO, String addressDTO, String phoneNumberDTO, double finalBalanceDTO, List<VehicleDTO> vehicleDTOS) {
//        this.dealerIDDTO = dealerIDDTO;
//        this.nameDTO = nameDTO;
//        this.addressDTO = addressDTO;
//        this.phoneNumberDTO = phoneNumberDTO;
//        this.finalBalanceDTO = finalBalanceDTO;
//        this.vehicleDTOS = new ArrayList<>(vehicleDTOS);
//    }
//
//    public CarDealershipDTO(int dealerIDDTO, String nameDTO, String addressDTO, String phoneNumberDTO, double finalBalanceDTO) {
//        this.dealerIDDTO = dealerIDDTO;
//        this.nameDTO = nameDTO;
//        this.addressDTO = addressDTO;
//        this.phoneNumberDTO = phoneNumberDTO;
//        this.finalBalanceDTO = finalBalanceDTO;
//        this.vehicleDTOS = new ArrayList<>();
//    }

    public CarDealershipDTO() {
    }

    public int getDealerIDDTO() {
        return dealerIDDTO;
    }

    public void setDealerIDDTO(int dealerIDDTO) {
        this.dealerIDDTO = dealerIDDTO;
    }

    public String getNameDTO() {
        return nameDTO;
    }

    public void setNameDTO(String name) {
        this.nameDTO = name;
    }

    public String getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(String address) {
        this.addressDTO = address;
    }

    public String getPhoneNumberDTO() {
        return phoneNumberDTO;
    }

    public void setPhoneNumberDTO(String phoneNumber) {
        this.phoneNumberDTO = phoneNumber;
    }

    public double getFinalBalanceDTO() {
        return finalBalanceDTO;
    }

    public void setFinalBalanceDTO(double finalBalance) {
        this.finalBalanceDTO = finalBalance;
    }

    public List<VehicleDTO> getVehicleDTOS() {
        return vehicleDTOS;
    }

    public void setVehicleDTOS(List<VehicleDTO> vehicleDTOS) {
        this.vehicleDTOS = new ArrayList<>(vehicleDTOS);
    }
}
