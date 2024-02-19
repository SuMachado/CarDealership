package com.example.CarDealership.DTOs;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class CarDealershipDTO extends RepresentationModel<CarDealershipDTO> {


    private int dealerIDDTO;

    private String nameDTO;

    private String addressDTO;
    private String phoneNumberDTO;
    private double finalBalanceDTO;

    private List<VehicleDTO> vehicleDTOS;

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
