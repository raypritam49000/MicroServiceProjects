package com.rating.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {
    private String ratingId;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
    private HotelDto hotelDto = new HotelDto();
}
