package com.example.CarDealership.Domain;

import com.example.CarDealership.DTOs.SellerDTO;
import com.example.CarDealership.DTOs.VehicleDTO;
import com.example.CarDealership.DTOs.VehicleModelDTO;
import com.example.CarDealership.Enums.BusinessStatus;
import com.example.CarDealership.Enums.FuelType;
import com.example.CarDealership.Enums.Traction;
import com.example.CarDealership.Enums.VehicleType;
import jakarta.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleID;
    @ManyToOne
    private VehicleModel vehicleModel;
    @Enumerated(EnumType.ORDINAL)
    private FuelType fuelType;
    private String licensePlate;
    private double mileage;
    private double purchasePrice;
    private double sellingPrice;
    @ManyToOne
    private Seller seller;
    @Enumerated(EnumType.ORDINAL)
    private VehicleType vehicleType;
    @Enumerated(EnumType.ORDINAL)
    private BusinessStatus businessStatus;
    private String colour;
    private int doors;
    private int seats;
    @Enumerated(EnumType.ORDINAL)
    private Traction traction;

    public Vehicle(int vehicleID, VehicleModel vehicleModel, FuelType fuelType, String licensePlate, double mileage, double purchasePrice,
                   double sellingPrice, Seller seller, VehicleType vehicleType, BusinessStatus businessStatus, String colour, int doors,
                   int seats, Traction traction) {
        this.vehicleID = vehicleID;
        this.vehicleModel = vehicleModel;
        this.fuelType = fuelType;
        this.licensePlate = licensePlate;
        this.mileage = mileage;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.seller = seller;
        this.vehicleType = vehicleType;
        this.businessStatus = businessStatus;
        this.colour = colour;
        this.doors = doors;
        this.seats = seats;
        this.traction=traction;
    }

    public Vehicle() {
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public VehicleModel getVehicleModel() {
        return vehicleModel;
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

    public Seller getSeller() {
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

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public void setVehicleModel(VehicleModel vehicleModel) {
        this.vehicleModel = vehicleModel;
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

    public void setSeller(Seller seller) {
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

    public Vehicle buildFromDTO(VehicleDTO dto){
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleID(dto.getVehicleIDDTO());

        VehicleModel vehicleModel1 = new VehicleModel();
        vehicleModel1=vehicleModel1.buildFromDTO(dto.getVehicleModelDTO());
        vehicle.setVehicleModel(vehicleModel1);

        vehicle.setFuelType(dto.getFuelTypeDTO());
        vehicle.setLicensePlate(dto.getLicensePlateDTO());
        vehicle.setMileage(dto.getMileageDTO());
        vehicle.setPurchasePrice(dto.getPurchasePriceDTO());
        vehicle.setSellingPrice(dto.getSellingPriceDTO());

        Seller seller1 = new Seller();
        seller1 = seller1.buildFromDTO(dto.getSellerDTO());
        vehicle.setSeller(seller1);

        vehicle.setVehicleType(dto.getVehicleTypeDTO());
        vehicle.setBusinessStatus(dto.getBusinessStatusDTO());
        vehicle.setColour(dto.getColourDTO());
        vehicle.setDoors(dto.getDoorsDTO());
        vehicle.setSeats(dto.getSeatsDTO());
        vehicle.setTraction(dto.getTractionDTO());
        return vehicle;
    }

    public VehicleDTO buildDTO(){
        VehicleDTO dto = new VehicleDTO();
        dto.setVehicleIDDTO(this.getVehicleID());

        VehicleModelDTO vehicleModelDTO1 = new VehicleModelDTO();
        VehicleModel vehicleModel1 = new VehicleModel();
        vehicleModelDTO1=vehicleModel1.buildDTO();
        dto.setVehicleModelDTO(vehicleModelDTO1);

        dto.setFuelTypeDTO(this.getFuelType());
        dto.setLicensePlateDTO(this.getLicensePlate());
        dto.setMileageDTO(this.getMileage());
        dto.setPurchasePriceDTO(this.getPurchasePrice());
        dto.setSellingPriceDTO(this.getSellingPrice());

        SellerDTO sellerDTO1 = new SellerDTO();
        Seller seller1 = new Seller();
        sellerDTO1=seller1.buildDTO();
        dto.setSellerDTO(sellerDTO1);

        dto.setVehicleTypeDTO(this.getVehicleType());
        dto.setBusinessStatusDTO(this.getBusinessStatus());
        dto.setColourDTO(this.getColour());
        dto.setDoorsDTO(this.getDoors());
        dto.setSeatsDTO(this.getSeats());
        dto.setTractionDTO(this.getTraction());
        return dto;
    }
}
