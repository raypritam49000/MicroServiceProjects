package com.rating.service.repository;

import com.rating.service.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public interface RatingRepository extends JpaRepository<Rating,String> {
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
