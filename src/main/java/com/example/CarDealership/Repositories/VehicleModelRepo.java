package com.example.CarDealership.Repositories;

import com.example.CarDealership.Domain.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleModelRepo extends JpaRepository<VehicleModel, Integer> {
}
