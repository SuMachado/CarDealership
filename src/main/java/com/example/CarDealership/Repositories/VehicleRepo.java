package com.example.CarDealership.Repositories;

import com.example.CarDealership.Domain.Vehicle;
import com.example.CarDealership.Enums.BusinessStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle, String> {

    @Query("SELECT v FROM Vehicle v WHERE v.businessStatus = :businessStatus")
    List<Vehicle> findByStatus(BusinessStatus businessStatus);

    @Query("SELECT v FROM Vehicle v WHERE v.buyerID = :buyerId")
    List<Vehicle> findByBuyerId(int buyerId);

    @Query("SELECT v FROM Vehicle v WHERE v.model.brand.brandId = :brandID")
    List<Vehicle> findByBrandId(int brandID);
}
