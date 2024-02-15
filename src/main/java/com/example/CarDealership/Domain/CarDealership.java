package com.example.CarDealership.Domain;

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
}
