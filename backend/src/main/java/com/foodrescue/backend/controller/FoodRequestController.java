package com.foodrescue.backend.controller;



import com.foodrescue.backend.dto.FoodRequestCreateRequest;
import com.foodrescue.backend.model.FoodRequest;
import com.foodrescue.backend.service.FoodRequestService;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class FoodRequestController {

    private final FoodRequestService foodRequestService;

    public FoodRequestController(FoodRequestService foodRequestService) {
        this.foodRequestService = foodRequestService;
    }

    @PostMapping
    public ResponseEntity<FoodRequest> createRequest(
            @Valid @RequestBody FoodRequestCreateRequest request,
            Authentication authentication) {

        String userEmail = authentication.getName();

        FoodRequest foodRequest =
                foodRequestService.createRequest(
                        request,
                        userEmail
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(foodRequest);
    }

    @GetMapping("/my")
public ResponseEntity<List<FoodRequest>> getMyRequests(
        Authentication authentication) {

    String userEmail = authentication.getName();

    return ResponseEntity.ok(
            foodRequestService.getMyRequests(userEmail)
    );
}
}