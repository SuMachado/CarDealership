package com.example.CarDealership.Repositories;

import com.example.CarDealership.Domain.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepo extends JpaRepository<Brand, Integer> {
}
