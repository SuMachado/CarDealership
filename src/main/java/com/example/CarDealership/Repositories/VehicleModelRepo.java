package com.example.CarDealership.Repositories;

import com.example.CarDealership.Domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleModelRepo extends JpaRepository<Model, Integer> {
}
