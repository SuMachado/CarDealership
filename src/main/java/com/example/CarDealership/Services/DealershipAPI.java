package com.example.CarDealership.Services;

import com.example.CarDealership.Domain.*;

import java.util.List;

public interface DealershipAPI {
    public Brand createBrand(Brand brand);

    public Brand getBrandByID(int id);
    public List<Brand> brandsList();
    public VehicleModel createVehicleModel(VehicleModel model);

    public VehicleModel getVehicleModelByID(int id);
    public List<VehicleModel> vehicleModelsList();

    public Vehicle createVehicle(Vehicle vehicle);

    public Vehicle getVehicleByID(int id);

    public List<Vehicle>vehiclesList();

    public CarDealership createDealership(CarDealership dealership);
    public CarDealership getDealershipByID(int id);
    public List<CarDealership>dealershipList();

    public Seller createSeller(Seller seller);
    public Seller getSellerByID(int id);
    public List<Seller> sellersList();
}
