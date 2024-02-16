package com.example.CarDealership.Domain;

import com.example.CarDealership.DTOs.CarDealershipDTO;
import com.example.CarDealership.DTOs.VehicleDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class CarDealership {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dealerID;

    private String name;

    private String address;
    private String phoneNumber;
    private double finalBalance;


    @ManyToOne
    private List<Vehicle> vehicles;

    public CarDealership(int dealerID, String name, String address, String phoneNumber, double finalBalance, List<Vehicle> vehicles) {
        this.dealerID = dealerID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.finalBalance = finalBalance;
        this.vehicles = new ArrayList<>(vehicles);
    }

    public CarDealership(int dealerID, String name, String address, String phoneNumber, double finalBalance) {
        this.dealerID = dealerID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.finalBalance = finalBalance;
        this.vehicles= new ArrayList<>();
    }

    public CarDealership() {
    }

    public int getDealerID() {
        return dealerID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getFinalBalance() {
        return finalBalance;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setDealerID(int dealerID) {
        this.dealerID = dealerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFinalBalance(double finalBalance) {
        this.finalBalance = finalBalance;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public CarDealershipDTO buildDTO(CarDealership carDealership) {
        CarDealershipDTO dto = new CarDealershipDTO();

        dto.setDealerIDDTO(carDealership.getDealerID());
        dto.setNameDTO(carDealership.getName());
        dto.setAddressDTO(carDealership.getAddress());
        dto.setPhoneNumberDTO(carDealership.getPhoneNumber());
        dto.setFinalBalanceDTO(carDealership.getFinalBalance());

        List <Vehicle>vehiclesList = carDealership.getVehicles();
        List <VehicleDTO>vehiclesDTOList = new ArrayList<>();
        for (Vehicle vehicle : vehiclesList) {
            vehiclesDTOList.add(vehicle.buildDTO(vehicle));
        }
        dto.setVehicleDTOS(vehiclesDTOList);

        return dto;
    }
}
