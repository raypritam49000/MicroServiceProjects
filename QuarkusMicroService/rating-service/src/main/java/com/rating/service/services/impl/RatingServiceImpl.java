package com.rating.service.services.impl;

import com.rating.service.dto.RatingDto;
import com.rating.service.entities.Rating;
import com.rating.service.exceptions.ResourceNotFoundException;
import com.rating.service.repository.RatingRepository;
import com.rating.service.services.RatingService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class RatingServiceImpl implements RatingService {

    @Inject
    private RatingRepository ratingRepository;

    @Inject
    private ModelMapper modelMapper;

    @Override
    public RatingDto create(RatingDto ratingDto) {
        return modelMapper.map(ratingRepository.save(modelMapper.map(ratingDto, Rating.class)), RatingDto.class);
    }

    @Override
    public List<RatingDto> getRatings() {
        return ratingRepository.findAll().stream().map(rating -> modelMapper.map(rating, RatingDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<RatingDto> getRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId).stream().map(rating -> modelMapper.map(rating, RatingDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<RatingDto> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId).stream().map(rating -> modelMapper.map(rating, RatingDto.class)).collect(Collectors.toList());
    }

    @Override
    public RatingDto updateRating(String id, RatingDto ratingDto) {
        Rating rating = ratingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rating Not Found With Id : " + id));
        rating.setRating(ratingDto.getRating());
        rating.setFeedback(rating.getFeedback());
        rating.setHotelId(ratingDto.getHotelId());
        rating.setUserId(ratingDto.getUserId());
        return modelMapper.map(ratingRepository.save(rating), RatingDto.class);
    }

    @Override
    public RatingDto getRating(String id) {
        Rating rating = ratingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Rating Not Found With Id : " + id));
        return modelMapper.map(rating, RatingDto.class);
    }
}
