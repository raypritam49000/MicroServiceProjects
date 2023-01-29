package com.hotel.service.services;

import com.hotel.service.dto.HotelDto;

import java.util.List;

public interface HotelService {

    //create
    HotelDto create(HotelDto hotelDto);

    //get all
    List<HotelDto> getAll();

    //get single
    HotelDto get(String id);

    void deleteHotel(String id);

    HotelDto updateHotel(String id,HotelDto hotelDto);

}
