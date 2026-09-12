package com.foodrescue.backend.repository;

import com.foodrescue.backend.model.FoodDonation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodDonationRepository extends JpaRepository<FoodDonation, Long> {
}