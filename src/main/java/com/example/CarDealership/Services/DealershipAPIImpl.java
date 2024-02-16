package com.example.CarDealership.Services;

import com.example.CarDealership.DTOs.*;
import com.example.CarDealership.Domain.*;
import com.example.CarDealership.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public BrandDTO createBrand(BrandDTO brandDTO) {
        Brand b1 = new Brand();
        b1= b1.buildFromDTO(brandDTO);
        b1=brandRepo.save(b1);
        return b1.buildDTO();
    }

    @Override
    public BrandDTO getBrandByID(int id) {
        Optional<Brand> b1= brandRepo.findById(id);
        if (b1!=null && b1.isPresent()){

            return b1.get().buildDTO();
        }
        return null;
    }

    @Override
    public List<BrandDTO> brandsList() {
        List<Brand> brands = brandRepo.findAll();
        if(brands.isEmpty()){
            return null;
        }
        List<BrandDTO> brandDTOS = new ArrayList<>();
        for(Brand brand : brands){
            brandDTOS.add(brand.buildDTO());
        }
        return brandDTOS;
    }

    @Override
    public BrandDTO updateBrand(BrandDTO brandDTO) {
        Brand b1=new Brand();
//        if(brandDTO.getNameDTO()!=null && !brand.getName().equals(brandDTO.getNameDTO())){
//            b1.setName(brandDTO.getNameDTO());
//        }
        b1= b1.buildFromDTO(brandDTO);
        b1=brandRepo.save(b1);
        return b1.buildDTO();
    }

    @Override
    public BrandDTO deleteBrand(int id) {
        Brand b1= brandRepo.findById(id).get();

        brandRepo.delete(b1);
        return b1.buildDTO();
    }

    @Override
    public VehicleModelDTO createVehicleModel(VehicleModelDTO model) {
        VehicleModel v1 = new VehicleModel();
        v1= v1.buildFromDTO(model);
        v1=vehicleModelRepo.save(v1);
        return v1.buildDTO();
    }

    @Override
    public VehicleModelDTO getVehicleModelByID(int id) {
        Optional<VehicleModel> m1= vehicleModelRepo.findById(id);
        if (m1!=null && m1.isPresent()){

            return m1.get().buildDTO();
        }
        return null;
    }

    @Override
    public List<VehicleModelDTO> vehicleModelsList() {
        List<VehicleModel> vehicleModels = vehicleModelRepo.findAll();
        if(vehicleModels.isEmpty()){
            return null;
        }
        List<VehicleModelDTO> vehicleModelDTOS = new ArrayList<>();
        for(VehicleModel vehicleModel : vehicleModels){
            vehicleModelDTOS.add(vehicleModel.buildDTO());
        }
        return vehicleModelDTOS;
    }

    @Override
    public VehicleModelDTO updateVehicleModel(VehicleModelDTO modelDTO) {
        VehicleModel v1= new VehicleModel();
        v1= v1.buildFromDTO(modelDTO);
        v1=vehicleModelRepo.save(v1);
        return v1.buildDTO();
    }

    @Override
    public VehicleModelDTO deleteVehicleModel(int id) {
        VehicleModel v1= vehicleModelRepo.findById(id).get();

        vehicleModelRepo.delete(v1);
        return v1.buildDTO();
    }


    @Override
    public SellerDTO createSeller(SellerDTO seller) {
        Seller s1 = new Seller();
        s1= s1.buildFromDTO(seller);
        s1=sellerRepo.save(s1);
        return s1.buildDTO();
    }

    @Override
    public SellerDTO getSellerByID(int id) {
        Optional<Seller> s1= sellerRepo.findById(id);
        if (s1!=null && s1.isPresent()){
            return s1.get().buildDTO();
        }
        return null;
    }

    @Override
    public List<SellerDTO> sellersList() {
        List<Seller> sellers = sellerRepo.findAll();
        if(sellers.isEmpty()){
            return null;
        }
        List<SellerDTO> sellerDTOS = new ArrayList<>();
        for(Seller seller : sellers){
            sellerDTOS.add(seller.buildDTO());
        }
        return sellerDTOS;
    }

    @Override
    public SellerDTO updateSeller(SellerDTO sellerDTO) {
        Seller s1= new Seller();

        s1= s1.buildFromDTO(sellerDTO);
        s1=sellerRepo.save(s1);
        return s1.buildDTO();
    }

    @Override
    public SellerDTO deleteSeller(int id) {
        Seller s1= sellerRepo.findById(id).get();
        sellerRepo.delete(s1);
        return s1.buildDTO();
    }


    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicle) {
        Vehicle v1 = new Vehicle();
        v1= v1.buildFromDTO(vehicle);
        v1=vehicleRepo.save(v1);
        return v1.buildDTO();
    }

    @Override
    public VehicleDTO getVehicleByID(int id) {
        Optional<Vehicle> v1= vehicleRepo.findById(id);
        if (v1!=null && v1.isPresent()){

            return v1.get().buildDTO();
        }
        return null;
    }

    @Override
    public List<VehicleDTO> vehiclesList() {
        List<Vehicle> vehicles = vehicleRepo.findAll();
        if(vehicles.isEmpty()){
            return null;
        }
        List<VehicleDTO> vehicleDTOS = new ArrayList<>();
        for(Vehicle vehicle : vehicles){
            vehicleDTOS.add(vehicle.buildDTO());
        }
        return vehicleDTOS;
    }

    @Override
    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO) {
        Vehicle v1= new Vehicle();

        v1= v1.buildFromDTO(vehicleDTO);
        v1=vehicleRepo.save(v1);
        return v1.buildDTO();
    }

    @Override
    public VehicleDTO deleteVehicle(int id) {

        Vehicle v1= vehicleRepo.findById(id).get();
        vehicleRepo.delete(v1);
        return v1.buildDTO();
    }




    @Override
    public CarDealershipDTO createDealership(CarDealershipDTO dealership) {
        CarDealership d1 = new CarDealership();
        d1= d1.buildFromDTO(dealership);
        d1=dealershipRepo.save(d1);
        return d1.buildDTO();
    }

    @Override
    public CarDealershipDTO getDealershipByID(int id) {
        Optional<CarDealership> d1= dealershipRepo.findById(id);
        if (d1!=null && d1.isPresent()){

            return d1.get().buildDTO();
        }
        return null;
    }

    @Override
    public List<CarDealershipDTO> dealershipList() {

        List<CarDealership> carDealerships = dealershipRepo.findAll();
        if(carDealerships.isEmpty()){
            return null;
        }
        List<CarDealershipDTO> carDealershipDTOS = new ArrayList<>();
        for(CarDealership carDealership : carDealerships){
            carDealershipDTOS.add(carDealership.buildDTO());
        }
        return carDealershipDTOS;
    }

    @Override
    public CarDealershipDTO updateDealership(CarDealershipDTO dealershipDTO) {
        CarDealership d1= new CarDealership();
        d1= d1.buildFromDTO(dealershipDTO);
        d1=dealershipRepo.save(d1);
        return d1.buildDTO();
    }

    @Override
    public CarDealershipDTO deleteDealership(int id) {

        CarDealership d1= dealershipRepo.findById(id).get();
        dealershipRepo.delete(d1);
        return d1.buildDTO();
    }
}
