package com.example.CarDealership.DTOs;

import com.example.CarDealership.Enums.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO extends RepresentationModel<VehicleDTO> {


    private String vin;
    private ModelDTO model;
    private FuelType fuelType;
    private String licensePlate;
    private double mileage;
    private double purchasePrice;
    private double sellingPrice;
    private SellerDTO seller;
    private VehicleType vehicleType;
    private BusinessStatus businessStatus;
    private String colour;
    private int doors;
    private int seats;
    private Traction traction;
    private int yearPlate;
    private int buyerID;
    private int transactionID;
    private State state;

    public String getVin() {
        return vin;
    }

    public ModelDTO getVehicleModel() {
        return model;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public double getMileage() {
        return mileage;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public SellerDTO getSeller() {
        return seller;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public BusinessStatus getBusinessStatus() {
        return businessStatus;
    }

    public String getColour() {
        return colour;
    }

    public int getDoors() {
        return doors;
    }

    public int getSeats() {
        return seats;
    }

    public Traction getTraction() {
        return traction;
    }

    public int getYearPlate() {
        return yearPlate;
    }

    public int getBuyerID() {
        return buyerID;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setBuyerID(int buyerID) {
        this.buyerID = buyerID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public void setYearPlate(int yearPlate) {
        this.yearPlate = yearPlate;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setVehicleModel(ModelDTO modelDTO) {
        this.model = modelDTO;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setSeller(SellerDTO seller) {
        this.seller = seller;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setBusinessStatus(BusinessStatus businessStatus) {
        this.businessStatus = businessStatus;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setTraction(Traction traction) {
        this.traction = traction;
    }
}
