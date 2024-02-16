package com.example.CarDealership.DTOs;

import com.example.CarDealership.Enums.BusinessStatus;
import com.example.CarDealership.Enums.FuelType;
import com.example.CarDealership.Enums.Traction;
import com.example.CarDealership.Enums.VehicleType;


public class VehicleDTO {


    private int vehicleIDDTO;
    private VehicleModelDTO vehicleModelDTO;
    private FuelType fuelTypeDTO;
    private String licensePlateDTO;
    private double mileageDTO;
    private double purchasePriceDTO;
    private double sellingPriceDTO;
    private SellerDTO sellerDTO;
    private VehicleType vehicleTypeDTO;
    private BusinessStatus businessStatusDTO;
    private String colourDTO;
    private int doorsDTO;
    private int seatsDTO;
    private Traction tractionDTO;

    public VehicleDTO(int vehicleIDDTO, VehicleModelDTO vehicleModelDTO, FuelType fuelTypeDTO, String licensePlateDTO, double mileageDTO, double purchasePriceDTO,
                      double sellingPriceDTO, SellerDTO sellerDTO, VehicleType vehicleTypeDTO, BusinessStatus businessStatusDTO, String colourDTO, int doorsDTO,
                      int seatsDTO, Traction tractionDTO) {
        this.vehicleIDDTO = vehicleIDDTO;
        this.vehicleModelDTO = vehicleModelDTO;
        this.fuelTypeDTO = fuelTypeDTO;
        this.licensePlateDTO = licensePlateDTO;
        this.mileageDTO = mileageDTO;
        this.purchasePriceDTO = purchasePriceDTO;
        this.sellingPriceDTO = sellingPriceDTO;
        this.sellerDTO = sellerDTO;
        this.vehicleTypeDTO = vehicleTypeDTO;
        this.businessStatusDTO = businessStatusDTO;
        this.colourDTO = colourDTO;
        this.doorsDTO = doorsDTO;
        this.seatsDTO = seatsDTO;
        this.tractionDTO = tractionDTO;
    }

    public VehicleDTO() {
    }

    public int getVehicleIDDTO() {
        return vehicleIDDTO;
    }

    public VehicleModelDTO getVehicleModelDTO() {
        return vehicleModelDTO;
    }

    public FuelType getFuelTypeDTO() {
        return fuelTypeDTO;
    }

    public String getLicensePlateDTO() {
        return licensePlateDTO;
    }

    public double getMileageDTO() {
        return mileageDTO;
    }

    public double getPurchasePriceDTO() {
        return purchasePriceDTO;
    }

    public double getSellingPriceDTO() {
        return sellingPriceDTO;
    }

    public SellerDTO getSellerDTO() {
        return sellerDTO;
    }

    public VehicleType getVehicleTypeDTO() {
        return vehicleTypeDTO;
    }

    public BusinessStatus getBusinessStatusDTO() {
        return businessStatusDTO;
    }

    public String getColourDTO() {
        return colourDTO;
    }

    public int getDoorsDTO() {
        return doorsDTO;
    }

    public int getSeatsDTO() {
        return seatsDTO;
    }

    public Traction getTractionDTO() {
        return tractionDTO;
    }

    public void setVehicleIDDTO(int vehicleIDDTO) {
        this.vehicleIDDTO = vehicleIDDTO;
    }

    public void setVehicleModelDTO(VehicleModelDTO vehicleModelDTO) {
        this.vehicleModelDTO = vehicleModelDTO;
    }

    public void setFuelTypeDTO(FuelType fuelTypeDTO) {
        this.fuelTypeDTO = fuelTypeDTO;
    }

    public void setLicensePlateDTO(String licensePlateDTO) {
        this.licensePlateDTO = licensePlateDTO;
    }

    public void setMileageDTO(double mileageDTO) {
        this.mileageDTO = mileageDTO;
    }

    public void setPurchasePriceDTO(double purchasePriceDTO) {
        this.purchasePriceDTO = purchasePriceDTO;
    }

    public void setSellingPriceDTO(double sellingPriceDTO) {
        this.sellingPriceDTO = sellingPriceDTO;
    }

    public void setSellerDTO(SellerDTO sellerDTO) {
        this.sellerDTO = sellerDTO;
    }

    public void setVehicleTypeDTO(VehicleType vehicleTypeDTO) {
        this.vehicleTypeDTO = vehicleTypeDTO;
    }

    public void setBusinessStatusDTO(BusinessStatus businessStatusDTO) {
        this.businessStatusDTO = businessStatusDTO;
    }

    public void setColourDTO(String colourDTO) {
        this.colourDTO = colourDTO;
    }

    public void setDoorsDTO(int doorsDTO) {
        this.doorsDTO = doorsDTO;
    }

    public void setSeatsDTO(int seatsDTO) {
        this.seatsDTO = seatsDTO;
    }

    public void setTractionDTO(Traction tractionDTO) {
        this.tractionDTO = tractionDTO;
    }
}
