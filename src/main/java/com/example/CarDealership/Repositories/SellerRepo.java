package com.example.CarDealership.Repositories;

import com.example.CarDealership.Domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepo extends JpaRepository<Seller, Integer> {
}
