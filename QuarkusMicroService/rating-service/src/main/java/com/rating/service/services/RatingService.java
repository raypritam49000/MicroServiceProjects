package com.rating.service.services;

import com.rating.service.dto.RatingDto;

import java.util.List;

public interface RatingService {

    //create
    RatingDto create(RatingDto ratingDto);

    //get all ratings
    List<RatingDto> getRatings();

    //get all by UserId
    List<RatingDto> getRatingByUserId(String userId);

    //get all by hotel
    List<RatingDto> getRatingByHotelId(String hotelId);

    // update
    RatingDto updateRating(String id,RatingDto ratingDto);

    // Get rating by id
    RatingDto getRating(String id);

}
