package com.foodrescue.backend.repository;

import com.foodrescue.backend.model.FoodDonation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodDonationRepository extends JpaRepository<FoodDonation, Long> {

    List<FoodDonation> findByDonorEmail(String email);
}