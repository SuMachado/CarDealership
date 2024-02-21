package com.example.CarDealership.Repositories;

import com.example.CarDealership.Domain.Vehicle;
import com.example.CarDealership.Enums.BusinessStatus;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle, String> {

    @Query("SELECT v FROM Vehicle v WHERE v.businessStatus = :businessStatus")
    Page<Vehicle> findByStatus(BusinessStatus businessStatus, Pageable page);

    @Query("SELECT v FROM Vehicle v WHERE v.buyerID = :buyerId")
    Page<Vehicle> findByBuyerId(int buyerId, Pageable page);

    @Query("SELECT v FROM Vehicle v WHERE v.model.brand.brandId = :brandID")
    Page<Vehicle> findByBrandId(int brandID, Pageable page);
}
