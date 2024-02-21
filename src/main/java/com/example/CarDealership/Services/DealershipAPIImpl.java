package com.example.CarDealership.Services;

import com.example.CarDealership.DTOs.*;
import com.example.CarDealership.Domain.*;
import com.example.CarDealership.Enums.BusinessStatus;
import com.example.CarDealership.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public Page<BrandDTO> brandsList(int page, int size, String sort) {
        return brandRepo.findAll(PageRequest.of(page, size, Sort.by(sort))).map(Brand::buildDTO);
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
    public Page<ModelDTO> vehicleModelsList(int page, int size, String sort) {
        return vehicleModelRepo.findAll(PageRequest.of(page, size, Sort.by(sort))).map(Model::buildDTO);
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
    public Page<SellerDTO> sellersList(int page, int size, String sort) {
        return sellerRepo.findAll(PageRequest.of(page, size, Sort.by(sort))).map(Seller::buildDTO);
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
                Model m1 = new Model();
                m=m1.buildFromDTO(modelDTO);
            }
            v1.setVehicleModel(m);
        }
        SellerDTO sellerDTO = vehicleDTO.getSellerDTO();
        if(sellerDTO != null) {
            Seller s = sellerRepo.findById(sellerDTO.getSellerIdDTO()).orElse(null);
            if(s == null&& sellerDTO.getSellerIdDTO() != 0) {
                sellerDTO = createSeller(sellerDTO);
                Seller s1 = new Seller();
                s=s1.buildFromDTO(sellerDTO);
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
    public Page<VehicleDTO> vehiclesList(int page, int size, String sort) {
        return vehicleRepo.findAll(PageRequest.of(page,size, Sort.by(sort))).map(Vehicle::buildDTO);
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


    //--------------------------------------Vehicles listing methods---------------------------------------------
    public Page<VehicleDTO> getVehiclesListByStatus(BusinessStatus status, int page, int size, String sort) {
        return vehicleRepo.findByStatus(status, PageRequest.of(page, size, Sort.by(sort))).map(Vehicle::buildDTO);
    }

    public Page<VehicleDTO> getVehiclesByBuyerId(int buyerId, int page, int size, String sort) {
        return vehicleRepo.findByBuyerId(buyerId, PageRequest.of(page, size, Sort.by(sort))).map(Vehicle::buildDTO);
    }


    public Page<VehicleDTO>getVehiclesByBrandID(int brandID, int page, int size, String sort) {
        return vehicleRepo.findByBrandId(brandID, PageRequest.of(page, size, Sort.by(sort))).map(Vehicle::buildDTO);
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
    public Page<CarDealershipDTO> dealershipList(int page, int size, String sort) {
        return dealershipRepo.findAll(PageRequest.of(page, size, Sort.by(sort))).map(CarDealership::buildDTO);
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
