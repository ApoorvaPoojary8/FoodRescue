package com.foodrescue.backend.dto;

import jakarta.validation.constraints.NotNull;

public class FoodRequestCreateRequest {

    @NotNull(message = "Donation ID is required")
    private Long donationId;

    public Long getDonationId() {
        return donationId;
    }

    public void setDonationId(Long donationId) {
        this.donationId = donationId;
    }
}