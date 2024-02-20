package com.example.CarDealership.Controller;

import com.example.CarDealership.DTOs.BrandDTO;
import com.example.CarDealership.DTOs.SellerDTO;
import com.example.CarDealership.DTOs.VehicleDTO;
import com.example.CarDealership.DTOs.ModelDTO;
import com.example.CarDealership.Domain.Vehicle;
import com.example.CarDealership.Enums.BusinessStatus;
import com.example.CarDealership.Services.DealershipAPI;
import com.example.CarDealership.Services.DealershipAPIImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/vehiclesCtrl")
public class VehicleController {

    private final DealershipAPIImpl api;

    @Autowired
    public VehicleController(DealershipAPIImpl api) {
        this.api = api;
    }



    @GetMapping("/brand/{id}")
    public ResponseEntity<BrandDTO> getBrandByID(@PathVariable("id") int id) {
        BrandDTO brand = api.getBrandByID(id);
        if (brand != null) {
            return new ResponseEntity<>(brand, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/brandsList")
    public CollectionModel<BrandDTO> getBrands() {
        List<BrandDTO> brandsList = api.brandsList();
        Link link = linkTo(methodOn(VehicleController.class).getBrands()).withSelfRel();

        CollectionModel<BrandDTO> resp = CollectionModel.of(brandsList, link);
        return resp;
    }

    @Transactional
    @PostMapping(value = "/createBrand", consumes = "application/json", produces = "application/json")
    public HttpEntity<BrandDTO> createBrand(@RequestBody BrandDTO brand) {
        BrandDTO brandDTO = api.getBrandByID(brand.getBrandIdDTO());
        if (brandDTO == null) {
            brandDTO = api.createBrand(brand);
            brandDTO.add(linkTo(methodOn(VehicleController.class).getBrandByID(brandDTO.getBrandIdDTO())).withSelfRel());
            brandDTO.add(linkTo(VehicleController.class).slash("brandsList").withRel("see_all_brands"));
            brandDTO.add(linkTo(methodOn(VehicleController.class).updateBrand(brandDTO.getBrandIdDTO(), brand)).withRel("update"));
            brandDTO.add(linkTo(methodOn(VehicleController.class).deleteBrand(brandDTO.getBrandIdDTO())).withRel("delete"));
            return new ResponseEntity<>(brandDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @PutMapping("/updateBrand/{id}")
    public ResponseEntity<BrandDTO> updateBrand(@PathVariable("id") int id, BrandDTO brandDTO) {
        BrandDTO brandDTO1 = api.getBrandByID(id);
        if (brandDTO1 != null) {
            if (brandDTO.getBrandIdDTO() != id) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            BrandDTO b = api.updateBrand(brandDTO);
            return new ResponseEntity<>(b, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/deleteBrand/{id}")
    public ResponseEntity<BrandDTO> deleteBrand(@PathVariable("id") int id) {
        BrandDTO brandDTO = api.getBrandByID(id);
        if (brandDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        brandDTO = api.deleteBrand(id);
        return new ResponseEntity<>(brandDTO, HttpStatus.OK);
    }

    @GetMapping("/model/{id}")
    public ResponseEntity<ModelDTO> getModelByID(@PathVariable("id") int id) {
        ModelDTO model = api.getVehicleModelByID(id);
        if (model != null) {
            return new ResponseEntity<>(model, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/ModelsList")
    public CollectionModel<ModelDTO> getModels() {
        List<ModelDTO> modelList = api.vehicleModelsList();
        Link link = linkTo(methodOn(VehicleController.class).getModels()).withSelfRel();

        CollectionModel<ModelDTO> resp = CollectionModel.of(modelList, link);
        return resp;
    }
    @Transactional
    @PostMapping(value = "/createModel", consumes = "application/json", produces = "application/json")
    public HttpEntity<ModelDTO> createModel(@RequestBody ModelDTO model) {
        ModelDTO modelDTO = api.getVehicleModelByID(model.getModelIdDTO());
        if (modelDTO == null) {
            modelDTO = api.createVehicleModel(model);
            modelDTO.add(linkTo(methodOn(VehicleController.class).getModelByID(model.getModelIdDTO())).withSelfRel());
            modelDTO.add(linkTo(methodOn(VehicleController.class).getModels()).withRel("see_all_models"));
            modelDTO.add(linkTo(methodOn(VehicleController.class).updateModel(model.getModelIdDTO(), model)).withRel("update"));
            modelDTO.add(linkTo(methodOn(VehicleController.class).deleteModel(model.getModelIdDTO())).withRel("delete"));
            return new ResponseEntity<>(modelDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @PutMapping("/updateModel/{id}")
    public ResponseEntity<ModelDTO> updateModel(@PathVariable("id") int id, ModelDTO modelDTO) {
        ModelDTO modelDTO1 = api.getVehicleModelByID(id);
        if (modelDTO1 != null) {
            if (modelDTO.getModelIdDTO() != id) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            ModelDTO m = api.updateVehicleModel(modelDTO);
            return new ResponseEntity<>(m, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteModel/{id}")
    public ResponseEntity<ModelDTO> deleteModel(@PathVariable("id") int id) {
        ModelDTO modelDTO = api.getVehicleModelByID(id);
        if (modelDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        modelDTO = api.deleteVehicleModel(id);

        return new ResponseEntity<>(modelDTO, HttpStatus.OK);
    }


    @GetMapping("/vehicle/{vin}")
    public ResponseEntity<VehicleDTO> getVehicleByVin(@PathVariable("vin") String id) {
        VehicleDTO vehicle = api.getVehicleByVin(id);
        if (vehicle != null) {
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/vehiclesList")
    public CollectionModel<VehicleDTO> getVehicles() {
        List<VehicleDTO> vehicleList = api.vehiclesList();
        Link link = linkTo(methodOn(VehicleController.class).getBrands()).withSelfRel();

        CollectionModel<VehicleDTO> resp = CollectionModel.of(vehicleList, link);
        return resp;
    }

    @Transactional
    @PostMapping(value = "/createVehicle", consumes = "application/json", produces = "application/json")
    public HttpEntity<VehicleDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        VehicleDTO vehicleDTO1 = api.getVehicleByVin(vehicleDTO.getVinDTO());
        if (vehicleDTO1 == null) {
            vehicleDTO1 = api.createVehicle(vehicleDTO);
            vehicleDTO1.add(linkTo(methodOn(VehicleController.class).getVehicleByVin(vehicleDTO.getVinDTO())).withSelfRel());
            vehicleDTO1.add(linkTo(methodOn(VehicleController.class).getVehicles()).withRel("see_all_vehicles"));
            vehicleDTO1.add(linkTo(methodOn(VehicleController.class).updateVehicle(vehicleDTO.getVinDTO(),vehicleDTO)).withRel("update"));
            vehicleDTO1.add(linkTo(methodOn(VehicleController.class).deleteVehicle(vehicleDTO.getVinDTO())).withRel("delete"));
            return new ResponseEntity<>(vehicleDTO1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @PutMapping("/updateVehicle/{vin}")
    public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable("vin") String id, VehicleDTO vehicleDTO) {
        VehicleDTO vehicleDTO1 = api.getVehicleByVin(id);
        if (vehicleDTO1 != null) {
            if (vehicleDTO.getVinDTO() != id) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            VehicleDTO v = api.updateVehicle(vehicleDTO);
            return new ResponseEntity<>(v, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteVehicle/{id}")
    public ResponseEntity<VehicleDTO> deleteVehicle(@PathVariable("id") String id) {
        VehicleDTO vehicleDTO = api.getVehicleByVin(id);
        if (vehicleDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        vehicleDTO = api.deleteVehicle(id);
        return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
    }

    @GetMapping("/seller/{id}")
    public ResponseEntity<SellerDTO> getSellerByID(@PathVariable("id") int id) {
        SellerDTO sellerDTO = api.getSellerByID(id);
        if (sellerDTO != null) {
            return new ResponseEntity<>(sellerDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/sellersList")
    public CollectionModel<SellerDTO> getSellers() {
        List<SellerDTO> sellersList = api.sellersList();
        Link link = linkTo(methodOn(VehicleController.class).getBrands()).withSelfRel();

        CollectionModel<SellerDTO> resp = CollectionModel.of(sellersList, link);
        return resp;
    }

    @Transactional
    @PostMapping(value = "/createSeller", consumes = "application/json", produces = "application/json")
    public HttpEntity<SellerDTO> createSeller(@RequestBody SellerDTO seller) {
        SellerDTO SellerDTO = api.getSellerByID(seller.getSellerIdDTO());
        if (SellerDTO == null) {
            SellerDTO = api.createSeller(seller);
            SellerDTO.add(linkTo(methodOn(VehicleController.class).getSellerByID(seller.getSellerIdDTO())).withSelfRel());
            SellerDTO.add(linkTo(methodOn(VehicleController.class).getSellers()).withRel("see_all_brands"));
            SellerDTO.add(linkTo(methodOn(VehicleController.class).updateSeller(seller.getSellerIdDTO(),seller)).withRel("update"));
            SellerDTO.add(linkTo(methodOn(VehicleController.class).deleteSeller(seller.getSellerIdDTO())).withRel("delete"));
            return new ResponseEntity<>(SellerDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @PutMapping("/updateSeller/{id}")
    public ResponseEntity<SellerDTO> updateSeller(@PathVariable("id") int id, SellerDTO seller) {
        SellerDTO sellerDTO = api.getSellerByID(id);
        if (sellerDTO != null) {
            if (seller.getSellerIdDTO() != id) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            SellerDTO s = api.updateSeller(seller);
            return new ResponseEntity<>(s, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/deleteSeller/{id}")
    public ResponseEntity<SellerDTO> deleteSeller(@PathVariable("id") int id) {
        SellerDTO sellerDTO = api.getSellerByID(id);
        if (sellerDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        sellerDTO = api.deleteSeller(id);
        return new ResponseEntity<>(sellerDTO, HttpStatus.OK);
    }

    @Transactional
    @PutMapping("/updateVehicleStatus/{vin}")
    public ResponseEntity<VehicleDTO> updateVehicleStatus(@PathVariable("vin") String vin, BusinessStatus status) {
        //BusinessStatus status1=BusinessStatus.valueOf(status);
        VehicleDTO vehicleDTO1 = api.getVehicleByVin(vin);
        if (vehicleDTO1 != null) {
            VehicleDTO vehicleDTO = api.updateVehicleStatus(vin, status);
            return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Transactional
    @PutMapping("/markVehicleAsSold/{vin}")
    public ResponseEntity<VehicleDTO> markVehicleAsSold(@PathVariable("vin") String vin, int buyerID, int transactionID, double sellingPrice) {
        VehicleDTO vehicleDTO = api.getVehicleByVin(vin);
        if (vehicleDTO != null) {
            BusinessStatus status = BusinessStatus.SOLD;
            vehicleDTO = api.updateVehicleStatus(vin, status);
            vehicleDTO = api.updateBuyerId(vin, buyerID, transactionID, sellingPrice);
            return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/vehiclesInStock")
    public CollectionModel<VehicleDTO> getVehiclesInStock() {
        List<VehicleDTO> vehiclesList = api.getVehiclesListByStatus(BusinessStatus.IN_STOCK);
        Link link = linkTo(methodOn(VehicleController.class).getVehiclesInStock()).withSelfRel();
        CollectionModel<VehicleDTO> resp = CollectionModel.of(vehiclesList, link);
        return resp;
    }

    @GetMapping("/vehiclesSold")
    public CollectionModel<VehicleDTO> getVehiclesSold() {
        List <VehicleDTO> vehiclesList = api.getVehiclesListByStatus(BusinessStatus.SOLD);
        Link link = linkTo(methodOn(VehicleController.class).getVehiclesSold()).withSelfRel();
        CollectionModel<VehicleDTO> resp = CollectionModel.of(vehiclesList, link);
        return resp;
    }

    @GetMapping("/vehiclesByBuyer/{buyerId}")
    public CollectionModel<VehicleDTO> getVehiclesByBuyer(@PathVariable("buyerId") int buyerId) {
        List<VehicleDTO> vehiclesList = api.getVehiclesByBuyerId(buyerId);
        if(vehiclesList.isEmpty()){
            return null;
        }
        Link link = linkTo(methodOn(VehicleController.class).getVehiclesByBuyer(buyerId)).withSelfRel();
        CollectionModel<VehicleDTO> resp = CollectionModel.of(vehiclesList, link);
        return resp;
    }

    @GetMapping("/vehiclesByBrand/{brandId}")
    public CollectionModel<VehicleDTO> getVehiclesByBrand(@PathVariable("brandId") int brandId) {
        List<VehicleDTO> vehiclesList = api.getVehiclesByBrandID(brandId);
        if(vehiclesList.isEmpty()){
            return null;
        }
        Link link = linkTo(methodOn(VehicleController.class).getVehiclesByBrand(brandId)).withSelfRel();
        CollectionModel<VehicleDTO> resp = CollectionModel.of(vehiclesList, link);
        return resp;
    }

}
