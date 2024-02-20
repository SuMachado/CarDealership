package com.example.CarDealership.Services;

import com.example.CarDealership.DTOs.*;
import com.example.CarDealership.Domain.*;
import com.example.CarDealership.Enums.BusinessStatus;
import com.example.CarDealership.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DealershipAPIImpl implements DealershipAPI {

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



//---------------------------------------------------Brand Methods-----------------------------------------------------
    @Transactional
    @Override
    public BrandDTO createBrand(BrandDTO brandDTO) {
        Brand b1 = new Brand();
        b1 = b1.buildFromDTO(brandDTO);
        b1 = brandRepo.save(b1);
        return b1.buildDTO();
    }

    @Override
    public BrandDTO getBrandByID(int id) {
        Optional<Brand> b1 = brandRepo.findById(id);
        if (b1.isPresent()) {

            return b1.get().buildDTO();
        }
        return null;
    }

    @Override
    public List<BrandDTO> brandsList() {
        List<Brand> brands = brandRepo.findAll();
        if (brands.isEmpty()) {
            return new ArrayList<>();
        }
        List<BrandDTO> brandDTOS = new ArrayList<>();
        for (Brand brand : brands) {
            brandDTOS.add(brand.buildDTO());
        }
        return brandDTOS;
    }

    @Transactional
    @Override
    public BrandDTO updateBrand(BrandDTO brandDTO) {
        Brand b1 = new Brand();
        b1 = b1.buildFromDTO(brandDTO);
        b1 = brandRepo.save(b1);
        return b1.buildDTO();
    }

    @Transactional
    @Override
    public BrandDTO deleteBrand(int id) {
        Brand b1 = brandRepo.findById(id).get();

        brandRepo.delete(b1);
        return b1.buildDTO();
    }

    //---------------------------------------------------Model Methods-----------------------------------------------------

    @Transactional
    @Override
    public ModelDTO createVehicleModel(ModelDTO model) {
        Model v1 = new Model();
        v1 = v1.buildFromDTO(model);
        BrandDTO brandDTO = model.getBrandDTO();
        if (brandDTO != null) {
            Brand d = brandRepo.findById(brandDTO.getBrandIdDTO()).orElse(null);
            if (d == null) {
                Brand newBrand = new Brand();
                newBrand.setName(brandDTO.getNameDTO());
                newBrand = brandRepo.save(newBrand);
                d = newBrand;

            }
            v1.setBrand(d);
            v1 = vehicleModelRepo.save(v1);
            return v1.buildDTO();
        }

        return null;
    }

    @Override
    public ModelDTO getVehicleModelByID(int id) {
        Optional<Model> m1 = vehicleModelRepo.findById(id);
        if (m1.isPresent()) {

            return m1.get().buildDTO();
        }
        return null;
    }

    @Override
    public List<ModelDTO> vehicleModelsList() {
        List<Model> models = vehicleModelRepo.findAll();
        if (models.isEmpty()) {
            return new ArrayList<>();
        }
        List<ModelDTO> modelDTOS = new ArrayList<>();
        for (Model model : models) {
            modelDTOS.add(model.buildDTO());
        }
        return modelDTOS;
    }

    @Transactional
    @Override
    public ModelDTO updateVehicleModel(ModelDTO modelDTO) {
        Model v1 = new Model();
        v1 = v1.buildFromDTO(modelDTO);
        BrandDTO brandDTO = modelDTO.getBrandDTO();
        if (brandDTO != null) {
            Brand d = brandRepo.findById(brandDTO.getBrandIdDTO()).orElse(null);
            if (d == null) {
                Brand newBrand = new Brand();
                newBrand.setName(brandDTO.getNameDTO());
                newBrand = brandRepo.save(newBrand);
                d = newBrand;
            }
            v1.setBrand(d);
        }
        v1 = vehicleModelRepo.save(v1);


        return v1.buildDTO();
    }

    @Transactional
    @Override
    public ModelDTO deleteVehicleModel(int id) {
        Model v1 = vehicleModelRepo.findById(id).get();

        vehicleModelRepo.delete(v1);
        return v1.buildDTO();
    }

//---------------------------------------------------Seller Methods-----------------------------------------------------
    @Transactional
    @Override
    public SellerDTO createSeller(SellerDTO seller) {
        Seller s1 = new Seller();
        s1 = s1.buildFromDTO(seller);
        s1 = sellerRepo.save(s1);
        return s1.buildDTO();
    }

    @Override
    public SellerDTO getSellerByID(int id) {
        Optional<Seller> s1 = sellerRepo.findById(id);
        if (s1.isPresent()) {
            return s1.get().buildDTO();
        }
        return null;
    }

    @Override
    public List<SellerDTO> sellersList() {
        List<Seller> sellers = sellerRepo.findAll();
        if (sellers.isEmpty()) {
            return null;
        }
        List<SellerDTO> sellerDTOS = new ArrayList<>();
        for (Seller seller : sellers) {
            sellerDTOS.add(seller.buildDTO());
        }
        return sellerDTOS;
    }

    @Transactional
    @Override
    public SellerDTO updateSeller(SellerDTO sellerDTO) {
        Seller s1 = new Seller();

        s1 = s1.buildFromDTO(sellerDTO);
        s1 = sellerRepo.save(s1);
        return s1.buildDTO();
    }

    @Transactional
    @Override
    public SellerDTO deleteSeller(int id) {
        Seller s1 = sellerRepo.findById(id).get();
        sellerRepo.delete(s1);
        return s1.buildDTO();
    }

//---------------------------------------------------Vehicle Methods-----------------------------------------------------
    @Transactional
    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
        Vehicle v1 = new Vehicle();
        v1 = v1.buildFromDTO(vehicleDTO);
        ModelDTO modelDTO = vehicleDTO.getVehicleModelDTO();
        if(modelDTO != null) {
            Model m = vehicleModelRepo.findById(modelDTO.getModelIdDTO()).orElse(null);
            if(m == null) {
                modelDTO = createVehicleModel(modelDTO);
                m=m.buildFromDTO(modelDTO);
            }
            v1.setVehicleModel(m);
        }
        SellerDTO sellerDTO = vehicleDTO.getSellerDTO();
        if(sellerDTO != null) {
            Seller s = sellerRepo.findById(sellerDTO.getSellerIdDTO()).orElse(null);
            if(s == null&& sellerDTO.getSellerIdDTO() != 0) {
                sellerDTO = createSeller(sellerDTO);
                s=s.buildFromDTO(sellerDTO);
            }
            v1.setSeller(s);
        }
        v1 = vehicleRepo.save(v1);
        return v1.buildDTO();
    }

    @Override
    public VehicleDTO getVehicleByVin(String id) {
        Optional<Vehicle> v1 = vehicleRepo.findById(id);
        if (v1.isPresent()) {

            return v1.get().buildDTO();
        }
        return null;
    }

    @Override
    public List<VehicleDTO> vehiclesList() {
        List<Vehicle> vehicles = vehicleRepo.findAll();
        if (vehicles.isEmpty()) {
            return null;
        }
        List<VehicleDTO> vehicleDTOS = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            vehicleDTOS.add(vehicle.buildDTO());
        }
        return vehicleDTOS;
    }

    @Transactional
    @Override
    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO) {
        Vehicle v1 = new Vehicle();
        v1 = v1.buildFromDTO(vehicleDTO);

        ModelDTO modelDTO = vehicleDTO.getVehicleModelDTO();
        if(modelDTO != null) {
            Model m = vehicleModelRepo.findById(modelDTO.getModelIdDTO()).orElse(null);
            if(m == null) {
                modelDTO = createVehicleModel(modelDTO);
                m=m.buildFromDTO(modelDTO);
            }
            v1.setVehicleModel(m);
        }
        v1 = vehicleRepo.save(v1);
        return v1.buildDTO();
    }

    @Transactional
    @Override
    public VehicleDTO deleteVehicle(String id) {

        Vehicle v1 = vehicleRepo.findById(id).get();
        vehicleRepo.delete(v1);
        return v1.buildDTO();
    }

    @Transactional
    public VehicleDTO updateVehicleStatus(String vin, BusinessStatus status) {

        Vehicle v1 = vehicleRepo.findById(vin).get();
        if (v1 == null) {
            return null;
        }
        v1.setBusinessStatus(status);
        vehicleRepo.save(v1);
        return v1.buildDTO();

    }

    @Transactional
    public VehicleDTO updateBuyerId(String vin, int buyerId, int transactionID, double sellingPrice) {

        Vehicle v1 = vehicleRepo.findById(vin).get();
        if (v1 == null) {
            return null;
        }
        v1.setBuyerID(buyerId);
        v1.setTransactionID(transactionID);
        v1.setSellingPrice(sellingPrice);
        vehicleRepo.save(v1);
        return v1.buildDTO();
    }

    public List<VehicleDTO> getVehiclesListByStatus(BusinessStatus status) {
        List<Vehicle> vehicles = vehicleRepo.findByStatus(status);
        if (vehicles.isEmpty()) {
            return null;
        }
        List<VehicleDTO> vehicleDTOS = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            vehicleDTOS.add(vehicle.buildDTO());
        }
        return vehicleDTOS;
    }

    public List<VehicleDTO> getVehiclesByBuyerId(int buyerId) {
        List<Vehicle> vehicles = vehicleRepo.findByBuyerId(buyerId);
        if (vehicles.isEmpty()) {
            return new ArrayList<>();
        }
        List<VehicleDTO> vehicleDTOS = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            vehicleDTOS.add(vehicle.buildDTO());
        }
        return vehicleDTOS;
    }

    public List<VehicleDTO>getVehiclesByBrandID(int brandID) {
        List<Vehicle> vehicles = vehicleRepo.findByBrandId(brandID);
        if (vehicles.isEmpty()) {
            return new ArrayList<>();
        }
        List<VehicleDTO> vehicleDTOS = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            vehicleDTOS.add(vehicle.buildDTO());
        }
        return vehicleDTOS;
    }




//------------------------------------------CarDealership methods---------------------------------------------

    @Transactional
    @Override
    public CarDealershipDTO createDealership(CarDealershipDTO dealership) {
        CarDealership d1 = new CarDealership();
        d1 = d1.buildFromDTO(dealership);
        d1 = dealershipRepo.save(d1);
        return d1.buildDTO();
    }

    @Override
    public CarDealershipDTO getDealershipByID(int id) {
        Optional<CarDealership> d1 = dealershipRepo.findById(id);
        if (d1.isPresent()) {

            return d1.get().buildDTO();
        }
        return null;
    }

    @Override
    public List<CarDealershipDTO> dealershipList() {

        List<CarDealership> carDealerships = dealershipRepo.findAll();
        if (carDealerships.isEmpty()) {
            return null;
        }
        List<CarDealershipDTO> carDealershipDTOS = new ArrayList<>();
        for (CarDealership carDealership : carDealerships) {
            carDealershipDTOS.add(carDealership.buildDTO());
        }
        return carDealershipDTOS;
    }

    @Transactional
    @Override
    public CarDealershipDTO updateDealership(CarDealershipDTO dealershipDTO) {
        CarDealership d1 = new CarDealership();
        d1 = d1.buildFromDTO(dealershipDTO);
        d1 = dealershipRepo.save(d1);
        return d1.buildDTO();
    }

    @Transactional
    @Override
    public CarDealershipDTO deleteDealership(int id) {

        CarDealership d1 = dealershipRepo.findById(id).get();
        dealershipRepo.delete(d1);
        return d1.buildDTO();
    }


}
