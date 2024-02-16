package com.example.CarDealership.Services;

import com.example.CarDealership.DTOs.*;
import com.example.CarDealership.Domain.*;

import java.util.List;

public interface DealershipAPI {

    public BrandDTO createBrand(BrandDTO brand);
    public BrandDTO getBrandByID(int id);
    public List<BrandDTO> brandsList();
    public BrandDTO updateBrand(BrandDTO branddto, Brand brand);
    public BrandDTO deleteBrand(int id);



    public VehicleModelDTO createVehicleModel(VehicleModelDTO model);
    public VehicleModelDTO getVehicleModelByID(int id);
    public List<VehicleModelDTO> vehicleModelsList();
    public VehicleModelDTO updateVehicleModel(VehicleModelDTO modelDTO, VehicleModel model);
    public VehicleModelDTO deleteVehicleModel(int id);


    public VehicleDTO createVehicle(VehicleDTO vehicle);
    public VehicleDTO getVehicleByID(int id);
    public List<VehicleDTO>vehiclesList();
    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO, Vehicle vehicle);
    public VehicleDTO deleteVehicle(int id);


    public SellerDTO createSeller(SellerDTO seller);
    public SellerDTO getSellerByID(int id);
    public List<SellerDTO> sellersList();
    public SellerDTO updateSeller(SellerDTO sellerDTO, Seller seller);
    public SellerDTO deleteSeller(int id);


    public CarDealershipDTO createDealership(CarDealershipDTO dealership);
    public CarDealershipDTO getDealershipByID(int id);
    public List<CarDealershipDTO>dealershipList();
    public CarDealershipDTO updateDealership(CarDealershipDTO dealershipDTO, CarDealership dealership);
    public CarDealershipDTO deleteDealership(int id);



}
