package com.example.CarDealership.Services;

import com.example.CarDealership.DTOs.*;
import com.example.CarDealership.Domain.*;
import com.example.CarDealership.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealershipAPIImpl implements DealershipAPI{

    @Autowired
    BrandRepo brandRepo;
    @Autowired
    CarDealershipRepo dealershipRepo;
    @Autowired
    SellerRepo sellerRepo;
    @Autowired
    VehicleModelRepo vehicleModelRepo;
    @Autowired
    VehicleRepo vehicleRepo;


    @Override
    public BrandDTO createBrand(BrandDTO brand) {
        return null;
    }

    @Override
    public BrandDTO getBrandByID(int id) {
        return null;
    }

    @Override
    public List<BrandDTO> brandsList() {
        return null;
    }

    @Override
    public VehicleModelDTO createVehicleModel(VehicleModelDTO model) {
        return null;
    }

    @Override
    public VehicleModelDTO getVehicleModelByID(int id) {
        return null;
    }

    @Override
    public List<VehicleModelDTO> vehicleModelsList() {
        return null;
    }

    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicle) {
        return null;
    }

    @Override
    public VehicleDTO getVehicleByID(int id) {
        return null;
    }

    @Override
    public List<VehicleDTO> vehiclesList() {
        return null;
    }

    @Override
    public CarDealershipDTO createDealership(CarDealershipDTO dealership) {
        return null;
    }

    @Override
    public CarDealershipDTO getDealershipByID(int id) {
        return null;
    }

    @Override
    public List<CarDealershipDTO> dealershipList() {
        return null;
    }

    @Override
    public SellerDTO createSeller(SellerDTO seller) {
        return null;
    }

    @Override
    public SellerDTO getSellerByID(int id) {
        return null;
    }

    @Override
    public List<SellerDTO> sellersList() {
        return null;
    }
}
