package com.foodrescue.backend.service;

import com.foodrescue.backend.dto.FoodRequestCreateRequest;
import com.foodrescue.backend.model.FoodDonation;
import com.foodrescue.backend.model.FoodRequest;
import com.foodrescue.backend.model.User;
import com.foodrescue.backend.repository.FoodDonationRepository;
import com.foodrescue.backend.repository.FoodRequestRepository;
import com.foodrescue.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FoodRequestService {

    private final FoodRequestRepository foodRequestRepository;
    private final FoodDonationRepository foodDonationRepository;
    private final UserRepository userRepository;

    public FoodRequestService(
            FoodRequestRepository foodRequestRepository,
            FoodDonationRepository foodDonationRepository,
            UserRepository userRepository) {

        this.foodRequestRepository = foodRequestRepository;
        this.foodDonationRepository = foodDonationRepository;
        this.userRepository = userRepository;
    }

    public FoodRequest createRequest(
            FoodRequestCreateRequest request,
            String userEmail) {

        User requester = userRepository.findByEmail(userEmail)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        FoodDonation donation =
                foodDonationRepository.findById(request.getDonationId())
                        .orElseThrow(() ->
                                new RuntimeException("Donation not found"));

        if (!donation.getStatus().equals("AVAILABLE")) {
            throw new RuntimeException(
                    "This donation is not available");
        }

        FoodRequest foodRequest = new FoodRequest();

        foodRequest.setDonation(donation);
        foodRequest.setRequester(requester);
        foodRequest.setStatus("PENDING");
        foodRequest.setRequestedAt(LocalDateTime.now());

        return foodRequestRepository.save(foodRequest);
    }
}