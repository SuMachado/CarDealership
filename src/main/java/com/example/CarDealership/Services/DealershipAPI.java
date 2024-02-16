package com.example.CarDealership.Services;

import com.example.CarDealership.DTOs.*;
import com.example.CarDealership.Domain.*;

import java.util.List;

public interface DealershipAPI {
    public BrandDTO createBrand(BrandDTO brand);
    public BrandDTO getBrandByID(int id);
    public List<BrandDTO> brandsList();

    public VehicleModelDTO createVehicleModel(VehicleModelDTO model);

    public VehicleModelDTO getVehicleModelByID(int id);
    public List<VehicleModelDTO> vehicleModelsList();

    public VehicleDTO createVehicle(VehicleDTO vehicle);
    public VehicleDTO getVehicleByID(int id);
    public List<VehicleDTO>vehiclesList();

    public CarDealershipDTO createDealership(CarDealershipDTO dealership);
    public CarDealershipDTO getDealershipByID(int id);
    public List<CarDealershipDTO>dealershipList();

    public SellerDTO createSeller(SellerDTO seller);
    public SellerDTO getSellerByID(int id);
    public List<SellerDTO> sellersList();
}
