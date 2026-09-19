package com.foodrescue.backend.repository;

import com.foodrescue.backend.model.FoodRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRequestRepository extends JpaRepository<FoodRequest, Long> {
}