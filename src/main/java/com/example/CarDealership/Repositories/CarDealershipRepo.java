package com.example.CarDealership.Repositories;

import com.example.CarDealership.Domain.CarDealership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDealershipRepo extends JpaRepository<CarDealership, Integer> {
}
