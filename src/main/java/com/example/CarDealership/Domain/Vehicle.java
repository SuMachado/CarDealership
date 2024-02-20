package com.example.CarDealership.Domain;

import com.example.CarDealership.DTOs.SellerDTO;
import com.example.CarDealership.DTOs.VehicleDTO;
import com.example.CarDealership.DTOs.ModelDTO;
import com.example.CarDealership.Enums.BusinessStatus;
import com.example.CarDealership.Enums.FuelType;
import com.example.CarDealership.Enums.Traction;
import com.example.CarDealership.Enums.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    private String vin;
    @ManyToOne//(fetch = FetchType.EAGER)
    private Model model;
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
    private int yearPlate;

    private int buyerID;
    private int transactionID;


    public String getVin() {
        return vin;
    }

    public Model getVehicleModel() {
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

    public Model getModel() {
        return model;
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

    public void setYearPlate(int yearPlate) {
        this.yearPlate = yearPlate;
    }

    public void setBuyerID(int buyerID) {
        this.buyerID = buyerID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setVehicleModel(Model model) {
        this.model = model;
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
        vehicle.setVin(dto.getVinDTO());

        Model model1 = new Model();
        model1 = model1.buildFromDTO(dto.getVehicleModelDTO());
        vehicle.setVehicleModel(model1);


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
        vehicle.setYearPlate(dto.getYearPlateDTO());
        vehicle.setBuyerID(dto.getBuyerIDDTO());
        vehicle.setTransactionID(dto.getTransactionIDDTO());
        return vehicle;
    }

    public VehicleDTO buildDTO(){
        VehicleDTO dto = new VehicleDTO();
        dto.setVinDTO(this.getVin());

        ModelDTO modelDTO1 = new ModelDTO();
        modelDTO1 = model.buildDTO();
        dto.setVehicleModelDTO(modelDTO1);

        dto.setFuelTypeDTO(this.getFuelType());
        dto.setLicensePlateDTO(this.getLicensePlate());
        dto.setMileageDTO(this.getMileage());
        dto.setPurchasePriceDTO(this.getPurchasePrice());
        dto.setSellingPriceDTO(this.getSellingPrice());

        SellerDTO sellerDTO1 = new SellerDTO();
        sellerDTO1=seller.buildDTO();
        dto.setSellerDTO(sellerDTO1);

        dto.setVehicleTypeDTO(this.getVehicleType());
        dto.setBusinessStatusDTO(this.getBusinessStatus());
        dto.setColourDTO(this.getColour());
        dto.setDoorsDTO(this.getDoors());
        dto.setSeatsDTO(this.getSeats());
        dto.setTractionDTO(this.getTraction());
        dto.setYearPlateDTO(this.getYearPlate());
        dto.setBuyerIDDTO(this.getBuyerID());
        dto.setTransactionIDDTO(this.getTransactionID());
        return dto;
    }
}
