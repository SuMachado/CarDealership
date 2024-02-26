package com.example.CarDealership.Controller;

import com.example.CarDealership.DTOs.BrandDTO;
import com.example.CarDealership.DTOs.SellerDTO;
import com.example.CarDealership.DTOs.VehicleDTO;
import com.example.CarDealership.DTOs.ModelDTO;
import com.example.CarDealership.Enums.BusinessStatus;
import com.example.CarDealership.Services.DealershipAPIImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    //------------------------------------------------Brand Methods-----------------------------------

    @GetMapping("/brand/{id}")
    public ResponseEntity<BrandDTO> getBrandByID(@PathVariable("id") int id) {
        BrandDTO brand = api.getBrandByID(id);
        if (brand != null) {
            return new ResponseEntity<>(brand, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/brandsList")
    public CollectionModel<BrandDTO> getBrands(@RequestParam(name = "page") Optional<Integer> page,
                                               @RequestParam(name = "size") Optional<Integer> size,
                                               @RequestParam(name = "sort") Optional<String> sort) {
        int _page = page.orElse(0);
        int _size = size.orElse(10);
        String _sort = sort.orElse("brandId");

        Page<BrandDTO> brandsList = api.brandsList(_page, _size, _sort);
        brandsList = brandsList.map((BrandDTO b) -> b.add(linkTo(methodOn(VehicleController.class).getBrandByID(b.getBrandId())).withSelfRel()));
        Link link = linkTo(methodOn(VehicleController.class).getBrands(page, size, sort)).withSelfRel();
        List<Link> links = new ArrayList<>();
        links.add(link);
        if (!brandsList.isLast()) {
            Link _link = linkTo(methodOn(VehicleController.class).getBrands(Optional.of(_page + 1), Optional.of(_size), Optional.of(_sort))).withRel("next");
            links.add(_link);
        }

        if (!brandsList.isFirst()) {
            Link _link = linkTo(methodOn(VehicleController.class).getBrands(Optional.of(_page - 1), Optional.of(_size), Optional.of(_sort))).withRel("previous");
            links.add(_link);
        }
        return CollectionModel.of(brandsList.toList(), links);
    }

    @PostMapping(value = "/createBrand", consumes = "application/json", produces = "application/json")
    public HttpEntity<BrandDTO> createBrand(@RequestBody BrandDTO brand) {

        BrandDTO brandDTO = api.createBrand(brand);
        if (brandDTO != null) {
            brandDTO.add(linkTo(methodOn(VehicleController.class).getBrandByID(brandDTO.getBrandId())).withSelfRel());
            brandDTO.add(linkTo(VehicleController.class).slash("brandsList").withRel("see_all_brands"));
            brandDTO.add(linkTo(methodOn(VehicleController.class).updateBrand(brandDTO.getBrandId(), brand)).withRel("update"));
            brandDTO.add(linkTo(methodOn(VehicleController.class).deleteBrand(brandDTO.getBrandId())).withRel("delete"));
            return new ResponseEntity<>(brandDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/updateBrand/{id}")
    public ResponseEntity<BrandDTO> updateBrand(@PathVariable("id") int id, BrandDTO brandDTO) {
        BrandDTO b = api.updateBrand(id, brandDTO);
        if (b != null) {
            return new ResponseEntity<>(b, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/deleteBrand/{id}")
    public ResponseEntity<BrandDTO> deleteBrand(@PathVariable("id") int id) {
        BrandDTO brandDTO = api.deleteBrand(id);
        if (brandDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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

    @GetMapping("/modelsList")
    public CollectionModel<ModelDTO> getModels(@RequestParam(name = "page") Optional<Integer> page,
                                               @RequestParam(name = "size") Optional<Integer> size,
                                               @RequestParam(name = "sort") Optional<String> sort) {
        int _page = page.orElse(0);
        int _size = size.orElse(10);
        String _sort = sort.orElse("modelId");

        Page<ModelDTO> modelsList = api.vehicleModelsList(_page, _size, _sort);
        modelsList = modelsList.map((ModelDTO b) -> b.add(linkTo(methodOn(VehicleController.class).getModelByID(b.getModelId())).withSelfRel()));

        Link link = linkTo(methodOn(VehicleController.class).getModels(page, size, sort)).withSelfRel();
        List<Link> links = new ArrayList<>();
        links.add(link);
        if (!modelsList.isLast()) {
            Link _link = linkTo(methodOn(VehicleController.class).getModels(Optional.of(_page + 1), Optional.of(_size), Optional.of(_sort))).withRel("next");
            links.add(_link);
        }

        if (!modelsList.isFirst()) {
            Link _link = linkTo(methodOn(VehicleController.class).getModels(Optional.of(_page - 1), Optional.of(_size), Optional.of(_sort))).withRel("previous");
            links.add(_link);
        }
        return CollectionModel.of(modelsList.toList(), links);

    }

    @PostMapping(value = "/createModel", consumes = "application/json", produces = "application/json")
    public HttpEntity<ModelDTO> createModel(@RequestBody ModelDTO model) {
        ModelDTO modelDTO = api.createVehicleModel(model);

        if (modelDTO != null) {
            modelDTO.add(linkTo(methodOn(VehicleController.class).getModelByID(model.getModelId())).withSelfRel());
            modelDTO.add(linkTo(methodOn(VehicleController.class).getModels(Optional.of(1), Optional.of(10), Optional.of("modelId"))).withRel("see_all_models"));
            modelDTO.add(linkTo(methodOn(VehicleController.class).updateModel(model.getModelId(), model)).withRel("update"));
            modelDTO.add(linkTo(methodOn(VehicleController.class).deleteModel(model.getModelId())).withRel("delete"));
            return new ResponseEntity<>(modelDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updateModel/{id}")
    public ResponseEntity<ModelDTO> updateModel(@PathVariable("id") int id, @RequestBody ModelDTO modelDTO) {

        ModelDTO m = api.updateVehicleModel(id, modelDTO);
        if (m != null) {
            return new ResponseEntity<>(m, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteModel/{id}")
    public ResponseEntity<ModelDTO> deleteModel(@PathVariable("id") int id) {
        ModelDTO modelDTO = api.deleteVehicleModel(id);
        if (modelDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(modelDTO, HttpStatus.OK);
    }

    //-------------------------------Seller methods--------------------------------------------

    @GetMapping("/seller/{id}")
    public ResponseEntity<SellerDTO> getSellerByID(@PathVariable("id") int id) {
        SellerDTO sellerDTO = api.getSellerByID(id);
        if (sellerDTO != null) {
            return new ResponseEntity<>(sellerDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/sellersList")
    public CollectionModel<SellerDTO> getSellers(@RequestParam(name = "page") Optional<Integer> page,
                                                 @RequestParam(name = "size") Optional<Integer> size,
                                                 @RequestParam(name = "sort") Optional<String> sort) {
        int _page = page.orElse(0);
        int _size = size.orElse(10);
        String _sort = sort.orElse("sellerId");

        Page<SellerDTO> sellerList = api.sellersList(_page, _size, _sort);
        Link link = linkTo(methodOn(VehicleController.class).getBrands(page, size, sort)).withSelfRel();

        List<Link> links = new ArrayList<>();
        links.add(link);
        if (!sellerList.isLast()) {
            Link _link = linkTo(methodOn(VehicleController.class).getBrands(Optional.of(_page + 1), Optional.of(_size), Optional.of(_sort))).withRel("next");
            links.add(_link);
        }

        if (!sellerList.isFirst()) {
            Link _link = linkTo(methodOn(VehicleController.class).getBrands(Optional.of(_page - 1), Optional.of(_size), Optional.of(_sort))).withRel("previous");
            links.add(_link);
        }

        return CollectionModel.of(sellerList.toList(), links);
    }

    @PostMapping(value = "/createSeller", consumes = "application/json", produces = "application/json")
    public HttpEntity<SellerDTO> createSeller(@RequestBody SellerDTO seller) {

        SellerDTO sellerDTO = api.createSeller(seller);
        if (sellerDTO != null) {

            sellerDTO.add(linkTo(methodOn(VehicleController.class).getSellerByID(seller.getSellerId())).withSelfRel());
            sellerDTO.add(linkTo(methodOn(VehicleController.class).getSellers(Optional.of(1), Optional.of(10), Optional.of("sellerId"))).withRel("see_all_brands"));
            sellerDTO.add(linkTo(methodOn(VehicleController.class).updateSeller(seller.getSellerId(), seller)).withRel("update"));
            sellerDTO.add(linkTo(methodOn(VehicleController.class).deleteSeller(seller.getSellerId())).withRel("delete"));
            return new ResponseEntity<>(sellerDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/updateSeller/{id}")
    public ResponseEntity<SellerDTO> updateSeller(@PathVariable("id") int id, SellerDTO seller) {
        SellerDTO s = api.updateSeller(id, seller);
        if (s != null) {
            return new ResponseEntity<>(s, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/deleteSeller/{id}")
    public ResponseEntity<SellerDTO> deleteSeller(@PathVariable("id") int id) {
        SellerDTO sellerDTO = api.deleteSeller(id);
        if (sellerDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sellerDTO, HttpStatus.OK);
    }


    //-------------------------------------Vehicle Methods---------------------------------

    @GetMapping("/vehicle/{vin}")
    public ResponseEntity<VehicleDTO> getVehicleByVin(@PathVariable("vin") String id) {
        VehicleDTO vehicle = api.getVehicleByVin(id);
        if (vehicle != null) {
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/vehiclesList")
    public CollectionModel<VehicleDTO> getVehicles(@RequestParam(name = "page") Optional<Integer> page,
                                                   @RequestParam(name = "size") Optional<Integer> size,
                                                   @RequestParam(name = "sort") Optional<String> sort) {
        int _page = page.orElse(0);
        int _size = size.orElse(10);
        String _sort = sort.orElse("vin");

        Page<VehicleDTO> vehicleList = api.vehiclesList(_page, _size, _sort);
        Link link = linkTo(methodOn(VehicleController.class).getBrands(page, size, sort)).withSelfRel();

        List<Link> links = new ArrayList<>();
        links.add(link);
        if (!vehicleList.isLast()) {
            Link _link = linkTo(methodOn(VehicleController.class).getBrands(Optional.of(_page + 1), Optional.of(_size), Optional.of(_sort))).withRel("next");
            links.add(_link);
        }

        if (!vehicleList.isFirst()) {
            Link _link = linkTo(methodOn(VehicleController.class).getBrands(Optional.of(_page - 1), Optional.of(_size), Optional.of(_sort))).withRel("previous");
            links.add(_link);
        }
        return CollectionModel.of(vehicleList.toList(), links);
    }

    @PostMapping(value = "/createVehicle", consumes = "application/json", produces = "application/json")
    public HttpEntity<VehicleDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO) {

        VehicleDTO vehicleDTO1 = api.createVehicle(vehicleDTO);
        if (vehicleDTO1 != null) {
            vehicleDTO1.add(linkTo(methodOn(VehicleController.class).getVehicleByVin(vehicleDTO.getVin())).withSelfRel());
            vehicleDTO1.add(linkTo(methodOn(VehicleController.class).getVehicles(Optional.of(1), Optional.of(10), Optional.of("vin"))).withRel("see_all_vehicles"));
            vehicleDTO1.add(linkTo(methodOn(VehicleController.class).updateVehicle(vehicleDTO.getVin(), vehicleDTO)).withRel("update"));
            vehicleDTO1.add(linkTo(methodOn(VehicleController.class).deleteVehicle(vehicleDTO.getVin())).withRel("delete"));
            return new ResponseEntity<>(vehicleDTO1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updateVehicle/{vin}")
    public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable("vin") String vin, @RequestBody VehicleDTO vehicleDTO) {

        VehicleDTO v = api.updateVehicle(vin, vehicleDTO);
        if (v != null) {
            return new ResponseEntity<>(v, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteVehicle/{id}")
    public ResponseEntity<VehicleDTO> deleteVehicle(@PathVariable("id") String id) {
        VehicleDTO vehicleDTO = api.deleteVehicle(id);
        if (vehicleDTO == null) {
            return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/updateVehicleStatus/{vin}")
    public ResponseEntity<VehicleDTO> updateVehicleStatus(@PathVariable("vin") String vin, BusinessStatus status) {

        VehicleDTO vehicleDTO1 = api.getVehicleByVin(vin);
        if (vehicleDTO1 != null) {
            VehicleDTO vehicleDTO = api.updateVehicleStatus(vin, status);
            return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/markVehicleAsSold/{vin}")
    public ResponseEntity<VehicleDTO> markVehicleAsSold(@PathVariable("vin") String vin, int buyerID, int transactionID, double sellingPrice) {
        BusinessStatus status = BusinessStatus.SOLD;

        VehicleDTO vehicleDTO = api.updateVehicleStatus(vin, status);
        if (vehicleDTO != null) {
            vehicleDTO = api.updateBuyerId(vin, buyerID, transactionID, sellingPrice);
            return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //falta "arrumar" daqui para baixo########################################


    @GetMapping("/vehiclesInStock")
    public CollectionModel<VehicleDTO> getVehiclesInStock(@RequestParam(name = "page") Optional<Integer> page,
                                                          @RequestParam(name = "size") Optional<Integer> size,
                                                          @RequestParam(name = "sort") Optional<String> sort) {

        int _page = page.orElse(0);
        int _size = size.orElse(10);
        String _sort = sort.orElse("vin");
        Page<VehicleDTO> vehiclesList = api.getVehiclesListByStatus(BusinessStatus.IN_STOCK, _page, _size, _sort);
        Link link = linkTo(methodOn(VehicleController.class).getVehiclesInStock(Optional.of(_page), Optional.of(_size), Optional.of(_sort))).withSelfRel();
        CollectionModel<VehicleDTO> resp = CollectionModel.of(vehiclesList.toList(), link);
        return resp;
    }

    @GetMapping("/vehiclesSold")
    public CollectionModel<VehicleDTO> getVehiclesSold(@RequestParam(name = "page") Optional<Integer> page,
                                                       @RequestParam(name = "size") Optional<Integer> size,
                                                       @RequestParam(name = "sort") Optional<String> sort) {

        int _page = page.orElse(0);
        int _size = size.orElse(10);
        String _sort = sort.orElse("vin");

        Page<VehicleDTO> vehiclesList = api.getVehiclesListByStatus(BusinessStatus.SOLD, _page, _size, _sort);
        Link link = linkTo(methodOn(VehicleController.class).getVehiclesSold(Optional.of(_page), Optional.of(_size), Optional.of(_sort))).withSelfRel();
        CollectionModel<VehicleDTO> resp = CollectionModel.of(vehiclesList.toList(), link);
        return resp;
    }

    @GetMapping("/vehiclesByBuyer/{buyerId}")
    public CollectionModel<VehicleDTO> getVehiclesByBuyer(@PathVariable("buyerId") int buyerId, @RequestParam(name = "page") Optional<Integer> page,
                                                          @RequestParam(name = "size") Optional<Integer> size,
                                                          @RequestParam(name = "sort") Optional<String> sort) {

        int _page = page.orElse(0);
        int _size = size.orElse(10);
        String _sort = sort.orElse("vin");

        Page<VehicleDTO> vehiclesList = api.getVehiclesByBuyerId(buyerId, _page, _size, _sort);
        Link link = linkTo(methodOn(VehicleController.class).getVehiclesByBuyer(buyerId, Optional.of(_page), Optional.of(_size), Optional.of(_sort))).withSelfRel();
        CollectionModel<VehicleDTO> resp = CollectionModel.of(vehiclesList.toList(), link);
        return resp;
    }


    @GetMapping("/vehiclesByBrand/{brandId}")
    public CollectionModel<VehicleDTO> getVehiclesByBrand(@PathVariable("brandId") int brandId, @RequestParam(name = "page") Optional<Integer> page,
                                                          @RequestParam(name = "size") Optional<Integer> size,
                                                          @RequestParam(name = "sort") Optional<String> sort) {

        int _page = page.orElse(0);
        int _size = size.orElse(10);
        String _sort = sort.orElse("vin");

        Page<VehicleDTO> vehiclesList = api.getVehiclesByBrandID(brandId, _page, _size, _sort);
        Link link = linkTo(methodOn(VehicleController.class).getVehiclesByBrand(brandId, Optional.of(_page), Optional.of(_size), Optional.of(_sort))).withSelfRel();
        CollectionModel<VehicleDTO> resp = CollectionModel.of(vehiclesList.toList(), link);
        return resp;
    }

}
