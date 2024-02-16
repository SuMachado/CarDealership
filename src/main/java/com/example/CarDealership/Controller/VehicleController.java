package com.example.CarDealership.Controller;

import com.example.CarDealership.DTOs.BrandDTO;
import com.example.CarDealership.DTOs.VehicleDTO;
import com.example.CarDealership.Services.DealershipAPIImpl;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
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

    DealershipAPIImpl api = new DealershipAPIImpl();

    @GetMapping("/brand/{id}")
    public ResponseEntity<BrandDTO> getBrandByID(@PathVariable("id") int id) {
        BrandDTO brand = api.getBrandByID(id);
        if (brand != null) {
            return new ResponseEntity<>(brand, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/brandsList")
    private CollectionModel<BrandDTO> getBrands() {
        List<BrandDTO> brandsList = api.brandsList();
        Link link = linkTo(methodOn(VehicleController.class).getBrands()).withSelfRel();

        CollectionModel<BrandDTO> resp = CollectionModel.of(brandsList, link);
        return resp;
    }

    @PostMapping(value = "/createBrand", consumes = "application/json", produces = "application/json")
    public HttpEntity<BrandDTO> createBrand(@RequestBody BrandDTO brand) {
        BrandDTO brandDTO = api.getBrandByID(brand.getBrandIdDTO());
        if (brandDTO == null) {
            brandDTO = api.createBrand(brand);
            brandDTO.add(linkTo(methodOn(VehicleController.class).getBrandByID(brand.getBrandIdDTO())).withSelfRel());
            brandDTO.add(linkTo(methodOn(VehicleController.class).getBrands()).withRel("see_all_brands"));
            brandDTO.add(linkTo(methodOn(VehicleController.class).updateBrand(brand.getBrandIdDTO(),brand)).withRel("update"));
            brandDTO.add(linkTo(methodOn(VehicleController.class).deleteBrand(brand.getBrandIdDTO())).withRel("delete"));
            return new ResponseEntity<>(brandDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/brandUpdate/{id}")
    public ResponseEntity<BrandDTO> updateBrand(@PathVariable("id") int id, BrandDTO brandDTO) {
        BrandDTO brandDTO1 = api.getBrandByID(id);
        if (brandDTO1 != null) {
            if (brandDTO.getBrandIdDTO() != id) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            BrandDTO b = api.updateBrand(brandDTO);
            return new ResponseEntity<>(b, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/vehicle/{id}")
    public ResponseEntity<VehicleDTO> getVehicleByID(@PathVariable("id") int id) {
        VehicleDTO vehicle = api.getVehicleByID(id);
        if (vehicle != null) {
            return new ResponseEntity<>(vehicle, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/brandeDelete/{id}")
    public HttpEntity<BrandDTO> deleteBrand(@PathVariable("id") int id) {
        BrandDTO brandDTO = api.getBrandByID(id);
        if (brandDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        brandDTO = api.deleteBrand(id);
        return new ResponseEntity<>(brandDTO, HttpStatus.OK);
    }


}
