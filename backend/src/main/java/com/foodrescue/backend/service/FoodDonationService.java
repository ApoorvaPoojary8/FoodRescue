package com.foodrescue.backend.service;
import com.foodrescue.backend.dto.FoodDonationRequest;
import com.foodrescue.backend.dto.FoodDonationUpdateRequest;
import com.foodrescue.backend.model.FoodDonation;
import com.foodrescue.backend.model.User;
import com.foodrescue.backend.repository.FoodDonationRepository;
import com.foodrescue.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodDonationService {

    private final FoodDonationRepository foodDonationRepository;
    private final UserRepository userRepository;

    public FoodDonationService(
            FoodDonationRepository foodDonationRepository,
            UserRepository userRepository) {

        this.foodDonationRepository = foodDonationRepository;
        this.userRepository = userRepository;
    }

    public FoodDonation createDonation(
            FoodDonationRequest request,
            String userEmail) {

        User donor = userRepository.findByEmail(userEmail)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        FoodDonation donation = new FoodDonation();

        donation.setFoodName(request.getFoodName());
        donation.setQuantity(request.getQuantity());
        donation.setDescription(request.getDescription());
        donation.setLocation(request.getLocation());
        donation.setExpiryTime(request.getExpiryTime());

        donation.setStatus("AVAILABLE");

        // Link donation to logged-in donor
        donation.setDonor(donor);

        return foodDonationRepository.save(donation);
    }

    public List<FoodDonation> getAllDonations() {
        return foodDonationRepository.findAll();
    }
    public List<FoodDonation> getMyDonations(String userEmail) {

    return foodDonationRepository.findByDonorEmail(userEmail);
}
public FoodDonation updateDonation(
        Long donationId,
        FoodDonationUpdateRequest request,
        String userEmail) {

    FoodDonation donation = foodDonationRepository.findById(donationId)
            .orElseThrow(() ->
                    new RuntimeException("Donation not found"));

    // Check whether this donation belongs to the logged-in user
    if (!donation.getDonor().getEmail().equals(userEmail)) {
        throw new RuntimeException(
                "You are not authorized to update this donation");
    }

    donation.setFoodName(request.getFoodName());
    donation.setQuantity(request.getQuantity());
    donation.setDescription(request.getDescription());
    donation.setLocation(request.getLocation());
    donation.setExpiryTime(request.getExpiryTime());

    return foodDonationRepository.save(donation);
}
public void deleteDonation(Long donationId, String userEmail) {

    FoodDonation donation = foodDonationRepository.findById(donationId)
            .orElseThrow(() ->
                    new RuntimeException("Donation not found"));

    // Check whether this donation belongs to the logged-in user
    if (!donation.getDonor().getEmail().equals(userEmail)) {
        throw new RuntimeException(
                "You are not authorized to delete this donation");
    }

    foodDonationRepository.delete(donation);
}
}