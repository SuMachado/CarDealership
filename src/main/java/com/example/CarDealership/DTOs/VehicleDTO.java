package com.example.CarDealership.DTOs;

import com.example.CarDealership.Enums.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO extends RepresentationModel<VehicleDTO> {


    private String vinDTO;
    private ModelDTO modelDTO;
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
    private int yearPlateDTO;
    private int buyerIDDTO;
    private int transactionIDDTO;
    private State stateDTO;

    public String getVinDTO() {
        return vinDTO;
    }

    public ModelDTO getVehicleModelDTO() {
        return modelDTO;
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

    public int getYearPlateDTO() {
        return yearPlateDTO;
    }

    public int getBuyerIDDTO() {
        return buyerIDDTO;
    }

    public int getTransactionIDDTO() {
        return transactionIDDTO;
    }

    public State getStateDTO() {
        return stateDTO;
    }

    public void setStateDTO(State stateDTO) {
        this.stateDTO = stateDTO;
    }

    public void setBuyerIDDTO(int buyerIDDTO) {
        this.buyerIDDTO = buyerIDDTO;
    }

    public void setTransactionIDDTO(int transactionIDDTO) {
        this.transactionIDDTO = transactionIDDTO;
    }

    public void setYearPlateDTO(int yearPlateDTO) {
        this.yearPlateDTO = yearPlateDTO;
    }

    public void setVinDTO(String vinDTO) {
        this.vinDTO = vinDTO;
    }

    public void setVehicleModelDTO(ModelDTO modelDTO) {
        this.modelDTO = modelDTO;
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
