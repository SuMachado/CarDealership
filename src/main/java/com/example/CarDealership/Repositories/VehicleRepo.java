package com.example.CarDealership.Repositories;

import com.example.CarDealership.Domain.Vehicle;
import com.example.CarDealership.Domain.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {
}
