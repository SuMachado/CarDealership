package com.example.CarDealership.Controller;

import com.example.CarDealership.DTOs.BrandDTO;
import com.example.CarDealership.DTOs.VehicleDTO;
import com.example.CarDealership.Domain.Brand;
import com.example.CarDealership.Services.DealershipAPIImpl;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/vehiclesCtrl")
public class VehicleController {

    DealershipAPIImpl api=new DealershipAPIImpl();

    @GetMapping("/brand/{id}")
    public ResponseEntity<BrandDTO> getBrandByID(@PathVariable("id")int id){
        BrandDTO brand=api.getBrandByID(id);
        if(brand != null){
            return new ResponseEntity<>(brand, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


//    private CollectionModel<BrandDTO>getBrands(){
//
//    }

    @PostMapping(value = "/createBrand", consumes = "application/json", produces ="application/json")
    public HttpEntity<BrandDTO>createBrand(@RequestBody BrandDTO brand){
        BrandDTO brandDTO= api.getBrandByID(brand.getBrandIdDTO());
        if(brandDTO == null){
            brandDTO=api.createBrand(brand);
//            brandDTO.add(linkTo(methodOn(VehicleController.class).getBrandByID(brand.getBrandIdDTO())).withSelfRel());
//            brandDTO.add(linkTo(methodOn(VehicleController.class).brandsList()).withRel("ver_todas_marcas"));
//            brandDTO.add(linkTo(methodOn(VehicleController.class).updateBrand(brand.getBrandIdDTO(),brand)).withRel("update"));
//            brandDTO.add(linkTo(methodOn(VehicleController.class).deleteBrand(brand.getBrandIdDTO())).withRel("delete"));
            return new ResponseEntity<>(brandDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }




    @GetMapping("/vehicle/{id}")
    public ResponseEntity<VehicleDTO> getVehicleByID(@PathVariable("id")int id){
        VehicleDTO vehicle=api.getVehicleByID(id);
        if(vehicle != null){
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




}
