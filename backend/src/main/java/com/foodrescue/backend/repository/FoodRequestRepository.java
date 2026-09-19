package com.foodrescue.backend.repository;

import com.foodrescue.backend.model.FoodRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRequestRepository extends JpaRepository<FoodRequest, Long> {

    List<FoodRequest> findByRequesterEmail(String email);
}