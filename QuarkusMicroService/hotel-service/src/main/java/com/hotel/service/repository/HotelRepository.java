package com.hotel.service.repository;

import com.hotel.service.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface HotelRepository extends JpaRepository<Hotel,String> {
}
