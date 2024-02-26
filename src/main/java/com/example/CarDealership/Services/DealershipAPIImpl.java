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
        BrandDTO brandDTO1 = getBrandByID(brandDTO.getBrandId());
        if (brandDTO1 != null) {
            return null;
        }
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
    public BrandDTO updateBrand(int id, BrandDTO brandDTO) {
        BrandDTO dto = getBrandByID(id);
        if (dto == null || id != brandDTO.getBrandId()) {
            return null;
        }

        Brand b1 = new Brand();
        b1 = b1.buildFromDTO(brandDTO);
        b1 = brandRepo.save(b1);
        return b1.buildDTO();
    }

    @Transactional
    @Override
    public BrandDTO deleteBrand(int id) {

        Brand b1 = brandRepo.findById(id).orElse(null);
        if (b1 == null) {
            return null;
        }
        brandRepo.delete(b1);
        return b1.buildDTO();
    }

    //---------------------------------------------------Model Methods-----------------------------------------------------

    @Transactional
    @Override
    public ModelDTO createVehicleModel(ModelDTO modelDTO) {
        ModelDTO modelDTO1 = getVehicleModelByID(modelDTO.getModelId());
        if (modelDTO1 != null) {
            return null;
        }

        Model v1 = new Model();
        v1 = v1.buildFromDTO(modelDTO);

        Brand brand = brandRepo.findById(modelDTO.getBrand().getBrandId()).orElse(null);
        if (brand == null) {
            return null;
        }
        v1.setBrand(brand);

        v1 = vehicleModelRepo.save(v1);
        return v1.buildDTO();

    }

    @Override
    public ModelDTO getVehicleModelByID(int id) {
        Model m1 = vehicleModelRepo.findById(id).orElse(null);
        if (m1 != null) {

            return m1.buildDTO();
        }
        return null;
    }

    @Override
    public Page<ModelDTO> vehicleModelsList(int page, int size, String sort) {
        return vehicleModelRepo.findAll(PageRequest.of(page, size, Sort.by(sort))).map(Model::buildDTO);
    }

    @Transactional
    @Override
    public ModelDTO updateVehicleModel(int id, ModelDTO modelDTO) {
        Model v1 = vehicleModelRepo.findById(modelDTO.getModelId()).orElse(null);
        if (v1 == null || id != modelDTO.getModelId()) {
            return null;
        }
        v1 = v1.buildFromDTO(modelDTO);

        if (modelDTO.getBrand() != null) {
            Brand d = brandRepo.findById(modelDTO.getBrand().getBrandId()).orElse(null);
            if (d == null) {
                return null;
            }
            v1.setBrand(d);
        }
        v1 = vehicleModelRepo.save(v1);

        return v1.buildDTO();
    }

    @Transactional
    @Override
    public ModelDTO deleteVehicleModel(int id) {
        Model v1 = vehicleModelRepo.findById(id).orElse(null);
        if (v1 == null) {
            return null;
        }

        vehicleModelRepo.delete(v1);
        return v1.buildDTO();
    }

    //---------------------------------------------------Seller Methods-----------------------------------------------------
    @Transactional
    @Override
    public SellerDTO createSeller(SellerDTO seller) {
        SellerDTO sellerDTO1 = getSellerByID(seller.getSellerId());

        if (sellerDTO1 != null ) {
            return null;
        }
        Seller s1 = new Seller();
        s1.buildFromDTO(seller);
        s1 = sellerRepo.save(s1);
        return s1.buildDTO();
    }


    @Override
    public SellerDTO getSellerByID(int id) {
        Seller s1 = sellerRepo.findById(id).orElse(null);
        if (s1 != null) {
            return s1.buildDTO();
        }
        return null;
    }

    @Override
    public Page<SellerDTO> sellersList(int page, int size, String sort) {
        return sellerRepo.findAll(PageRequest.of(page, size, Sort.by(sort))).map(Seller::buildDTO);
    }

    @Transactional
    @Override
    public SellerDTO updateSeller(int id, SellerDTO sellerDTO) {
        SellerDTO sellerDTO1 = getSellerByID(sellerDTO.getSellerId());

        if (sellerDTO1 == null || id != sellerDTO1.getSellerId()) {
            return null;
        }
        Seller s1 = new Seller();
        s1 = s1.buildFromDTO(sellerDTO);
        s1 = sellerRepo.save(s1);
        return s1.buildDTO();
    }

    @Transactional
    @Override
    public SellerDTO deleteSeller(int id) {
        Seller s1 = sellerRepo.findById(id).orElse(null);
        if (s1 == null) {
            return null;
        }
        sellerRepo.delete(s1);
        return s1.buildDTO();
    }

    //---------------------------------------------------Vehicle Methods-----------------------------------------------------
    @Transactional
    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
        VehicleDTO vehicleDTO1 = getVehicleByVin(vehicleDTO.getVin());
        if (vehicleDTO1 != null) {
            return null;
        }

        Vehicle v1 = new Vehicle();
        v1 = v1.buildFromDTO(vehicleDTO);

        ModelDTO modelDTO = vehicleDTO.getVehicleModel();
        if (modelDTO != null) {
            Model m = vehicleModelRepo.findById(modelDTO.getModelId()).orElse(null);
            if (m == null) {
                return null;
            }
            v1.setVehicleModel(m);
        }

        SellerDTO sellerDTO = vehicleDTO.getSeller();
        if (sellerDTO != null) {
            Seller s = sellerRepo.findById(sellerDTO.getSellerId()).orElse(null);
            if (s == null ) {
                return null;
            }
            v1.setSeller(s);
        }
        v1 = vehicleRepo.save(v1);
        return v1.buildDTO();
    }

    @Override
    public VehicleDTO getVehicleByVin(String id) {
        Vehicle v1 = vehicleRepo.findById(id).orElse(null);

        if (v1 != null) {
            return v1.buildDTO();
        }
        return null;
    }

    @Override
    public Page<VehicleDTO> vehiclesList(int page, int size, String sort) {
        return vehicleRepo.findAll(PageRequest.of(page, size, Sort.by(sort))).map(Vehicle::buildDTO);
    }

    @Transactional
    @Override
    public VehicleDTO updateVehicle(String vin, VehicleDTO vehicleDTO) {
        VehicleDTO vehicleDTO1 = getVehicleByVin(vin);
        if(vehicleDTO1 == null || !vin.equals(vehicleDTO.getVin())) {
            return null;
        }

        Vehicle v1 = new Vehicle();
        v1 = v1.buildFromDTO(vehicleDTO);

        ModelDTO modelDTO = vehicleDTO.getVehicleModel();
        if (modelDTO != null) {
            Model m = vehicleModelRepo.findById(modelDTO.getModelId()).orElse(null);
            if (m == null) {
                return null;
            }
            v1.setVehicleModel(m);
        }

        SellerDTO sellerDTO = vehicleDTO.getSeller();
        if (sellerDTO != null) {
            Seller s = sellerRepo.findById(sellerDTO.getSellerId()).orElse(null);
            if (s == null ) {
                return null;
            }
            v1.setSeller(s);
        }

        v1 = vehicleRepo.save(v1);
        return v1.buildDTO();

    }

    @Transactional
    @Override
    public VehicleDTO deleteVehicle(String id) {
        Vehicle v1 = vehicleRepo.findById(id).orElse(null);
        if (v1 == null) {
            return null;
        }
        vehicleRepo.delete(v1);
        return v1.buildDTO();
    }


    @Transactional
    public VehicleDTO updateVehicleStatus(String vin, BusinessStatus status) {

        Vehicle v1 = vehicleRepo.findById(vin).orElse(null);
        if (v1 == null) {
            return null;
        }
        v1.setBusinessStatus(status);
        vehicleRepo.save(v1);
        return v1.buildDTO();

    }



    @Transactional
    public VehicleDTO updateBuyerId(String vin, int buyerId, int transactionID, double sellingPrice) {

        Vehicle v1 = vehicleRepo.findById(vin).orElse(null);
        if (v1 == null) {
            return null;
        }
        v1.setBuyerID(buyerId);
        v1.setTransactionID(transactionID);
        v1.setSellingPrice(sellingPrice);
        vehicleRepo.save(v1);
        return v1.buildDTO();
    }

    //falta "arrumar" daqui para baixo########################################

    //--------------------------------------Vehicles listing methods---------------------------------------------
    public Page<VehicleDTO> getVehiclesListByStatus(BusinessStatus status, int page, int size, String sort) {
        return vehicleRepo.findByStatus(status, PageRequest.of(page, size, Sort.by(sort))).map(Vehicle::buildDTO);
    }

    public Page<VehicleDTO> getVehiclesByBuyerId(int buyerId, int page, int size, String sort) {
        return vehicleRepo.findByBuyerId(buyerId, PageRequest.of(page, size, Sort.by(sort))).map(Vehicle::buildDTO);
    }


    public Page<VehicleDTO> getVehiclesByBrandID(int brandID, int page, int size, String sort) {
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
