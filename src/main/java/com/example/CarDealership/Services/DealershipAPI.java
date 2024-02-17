package com.example.CarDealership.Services;

import com.example.CarDealership.DTOs.*;

import java.util.List;

public interface DealershipAPI {

    public BrandDTO createBrand(BrandDTO brand);
    public BrandDTO getBrandByID(int id);
    public List<BrandDTO> brandsList();
    public BrandDTO updateBrand(BrandDTO branddto);
    public BrandDTO deleteBrand(int id);



    public ModelDTO createVehicleModel(ModelDTO model);
    public ModelDTO getVehicleModelByID(int id);
    public List<ModelDTO> vehicleModelsList();
    public ModelDTO updateVehicleModel(ModelDTO modelDTO);
    public ModelDTO deleteVehicleModel(int id);


    public VehicleDTO createVehicle(VehicleDTO vehicle);
    public VehicleDTO getVehicleByID(int id);
    public List<VehicleDTO>vehiclesList();
    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO);
    public VehicleDTO deleteVehicle(int id);


    public SellerDTO createSeller(SellerDTO seller);
    public SellerDTO getSellerByID(int id);
    public List<SellerDTO> sellersList();
    public SellerDTO updateSeller(SellerDTO sellerDTO);
    public SellerDTO deleteSeller(int id);


    public CarDealershipDTO createDealership(CarDealershipDTO dealership);
    public CarDealershipDTO getDealershipByID(int id);
    public List<CarDealershipDTO>dealershipList();
    public CarDealershipDTO updateDealership(CarDealershipDTO dealershipDTO);
    public CarDealershipDTO deleteDealership(int id);



}
