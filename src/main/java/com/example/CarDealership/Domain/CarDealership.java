package com.example.CarDealership.Domain;

import com.example.CarDealership.DTOs.CarDealershipDTO;
import com.example.CarDealership.DTOs.VehicleDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CarDealership {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int dealerID;

    private String name;

    private String address;
    private String phoneNumber;


    @OneToMany
    private List<Vehicle> vehicles;


//    public CarDealership(int dealerID, String name, String address, String phoneNumber, double finalBalance, List<Vehicle> vehicles) {
//        this.dealerID = dealerID;
//        this.name = name;
//        this.address = address;
//        this.phoneNumber = phoneNumber;
//        this.finalBalance = finalBalance;
//        this.vehicles = new ArrayList<>(vehicles);
//    }
//
//    public CarDealership(int dealerID, String name, String address, String phoneNumber, double finalBalance) {
//        this.dealerID = dealerID;
//        this.name = name;
//        this.address = address;
//        this.phoneNumber = phoneNumber;
//        this.finalBalance = finalBalance;
//        this.vehicles= new ArrayList<>();
//    }
//
//    public CarDealership() {
//    }

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


    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public CarDealershipDTO buildDTO() {
        CarDealershipDTO dto = new CarDealershipDTO();

        dto.setDealerIDDTO(this.getDealerID());
        dto.setNameDTO(this.getName());
        dto.setAddressDTO(this.getAddress());
        dto.setPhoneNumberDTO(this.getPhoneNumber());

        List <Vehicle>vehiclesList = this.getVehicles();
        List <VehicleDTO>vehiclesDTOList = new ArrayList<>();
        for (Vehicle vehicle : vehiclesList) {
            vehiclesDTOList.add(vehicle.buildDTO());
        }
        dto.setVehicleDTOS(vehiclesDTOList);

        return dto;
    }

    public CarDealership buildFromDTO(CarDealershipDTO dto) {
        CarDealership carDealership = new CarDealership();
        carDealership.setDealerID(dto.getDealerIDDTO());
        carDealership.setName(dto.getNameDTO());
        carDealership.setAddress(dto.getAddressDTO());
        carDealership.setPhoneNumber(dto.getPhoneNumberDTO());

        Vehicle vehicle = new Vehicle();
        List <VehicleDTO> vehiclesDTOList = dto.getVehicleDTOS();
        List <Vehicle> vehiclesList = new ArrayList<>();
        for (VehicleDTO vehicleDTO : vehiclesDTOList) {
            vehiclesList.add(vehicle.buildFromDTO(vehicleDTO));
        }
        carDealership.setVehicles(vehiclesList);

        return carDealership;
    }
}
