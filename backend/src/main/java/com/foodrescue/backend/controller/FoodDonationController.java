package com.foodrescue.backend.controller;

import com.foodrescue.backend.dto.FoodDonationRequest;
import com.foodrescue.backend.model.FoodDonation;
import com.foodrescue.backend.service.FoodDonationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donations")
public class FoodDonationController {

    private final FoodDonationService foodDonationService;

    public FoodDonationController(FoodDonationService foodDonationService) {
        this.foodDonationService = foodDonationService;
    }

    @PostMapping
    public ResponseEntity<FoodDonation> createDonation(
            @Valid @RequestBody FoodDonationRequest request,
            Authentication authentication) {

        String userEmail = authentication.getName();

        FoodDonation donation =
                foodDonationService.createDonation(request, userEmail);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(donation);
    }

    @GetMapping
    public ResponseEntity<List<FoodDonation>> getAllDonations() {

        return ResponseEntity.ok(
                foodDonationService.getAllDonations()
        );
    }
}