package com.example.CarDealership.Services;

import com.example.CarDealership.DTOs.*;

import java.util.List;

public interface DealershipAPI {

    BrandDTO createBrand(BrandDTO brand);
    BrandDTO getBrandByID(int id);
    List<BrandDTO> brandsList();
    BrandDTO updateBrand(BrandDTO branddto);
    BrandDTO deleteBrand(int id);



    ModelDTO createVehicleModel(ModelDTO model);
    ModelDTO getVehicleModelByID(int id);
    List<ModelDTO> vehicleModelsList();
    ModelDTO updateVehicleModel(ModelDTO modelDTO);
    ModelDTO deleteVehicleModel(int id);


    VehicleDTO createVehicle(VehicleDTO vehicle);
    VehicleDTO getVehicleByVin(String id);
    List<VehicleDTO>vehiclesList();
    VehicleDTO updateVehicle(VehicleDTO vehicleDTO);
    VehicleDTO deleteVehicle(String id);


    SellerDTO createSeller(SellerDTO seller);
    SellerDTO getSellerByID(int id);
    List<SellerDTO> sellersList();
    SellerDTO updateSeller(SellerDTO sellerDTO);
    SellerDTO deleteSeller(int id);


    CarDealershipDTO createDealership(CarDealershipDTO dealership);
    CarDealershipDTO getDealershipByID(int id);
    List<CarDealershipDTO>dealershipList();
    CarDealershipDTO updateDealership(CarDealershipDTO dealershipDTO);
    CarDealershipDTO deleteDealership(int id);



}
