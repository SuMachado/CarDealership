package com.example.CarDealership.Services;

import com.example.CarDealership.DTOs.*;
import com.example.CarDealership.Enums.BusinessStatus;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DealershipAPI {

    BrandDTO createBrand(BrandDTO brand);
    BrandDTO getBrandByID(int id);
    Page<BrandDTO> brandsList(int page, int size, String sort);
    BrandDTO updateBrand(BrandDTO branddto);
    BrandDTO deleteBrand(int id);



    ModelDTO createVehicleModel(ModelDTO model);
    ModelDTO getVehicleModelByID(int id);
    Page<ModelDTO> vehicleModelsList(int page, int size, String sort);
    ModelDTO updateVehicleModel(ModelDTO modelDTO);
    ModelDTO deleteVehicleModel(int id);


    VehicleDTO createVehicle(VehicleDTO vehicle);
    VehicleDTO getVehicleByVin(String id);
    Page<VehicleDTO>vehiclesList(int page, int size, String sort);
    VehicleDTO updateVehicle(VehicleDTO vehicleDTO);
    VehicleDTO deleteVehicle(String id);


    SellerDTO createSeller(SellerDTO seller);
    SellerDTO getSellerByID(int id);
    Page<SellerDTO> sellersList(int page, int size, String sort);
    SellerDTO updateSeller(SellerDTO sellerDTO);
    SellerDTO deleteSeller(int id);


    CarDealershipDTO createDealership(CarDealershipDTO dealership);
    CarDealershipDTO getDealershipByID(int id);
    Page<CarDealershipDTO>dealershipList(int page, int size, String sort);
    CarDealershipDTO updateDealership(CarDealershipDTO dealershipDTO);
    CarDealershipDTO deleteDealership(int id);


    Page<VehicleDTO> getVehiclesListByStatus(BusinessStatus status, int page, int size, String sort);
    Page<VehicleDTO> getVehiclesByBuyerId(int buyerId, int page, int size, String sort);
    Page<VehicleDTO>getVehiclesByBrandID(int brandID, int page, int size, String sort);

}
