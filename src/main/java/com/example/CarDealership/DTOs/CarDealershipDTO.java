package com.example.CarDealership.DTOs;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


public class CarDealershipDTO {


    private int dealerID;

    private String name;

    private String address;
    private String phoneNumber;
    private double finalBalance;

    private List<VehicleDTO> vehicleDTOS;

    public CarDealershipDTO(int dealerID, String name, String address, String phoneNumber, double finalBalance, List<VehicleDTO> vehicleDTOS) {
        this.dealerID = dealerID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.finalBalance = finalBalance;
        this.vehicleDTOS = new ArrayList<>(vehicleDTOS);
    }

    public CarDealershipDTO(int dealerID, String name, String address, String phoneNumber, double finalBalance) {
        this.dealerID = dealerID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.finalBalance = finalBalance;
        this.vehicleDTOS = new ArrayList<>();
    }
}
