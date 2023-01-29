package com.hotel.service.services.impl;

import com.hotel.service.dto.HotelDto;
import com.hotel.service.entity.Hotel;
import com.hotel.service.exceptions.ResourceNotFoundException;
import com.hotel.service.repository.HotelRepository;
import com.hotel.service.services.HotelService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class HotelServiceImpl implements HotelService {

    @Inject
    private HotelRepository hotelRepository;

    @Inject
    private ModelMapper modelMapper;

    @Override
    public HotelDto create(HotelDto hotelDto) {
        return modelMapper.map(hotelRepository.save(modelMapper.map(hotelDto, Hotel.class)),HotelDto.class);
    }

    @Override
    public List<HotelDto> getAll() {
        List<HotelDto> hotelDtoList = hotelRepository.findAll().stream()
                .map(hotel->modelMapper.map(hotel,HotelDto.class)).collect(Collectors.toList());
        return hotelDtoList;
    }

    @Override
    public HotelDto get(String id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel Not Found with Id : "+id));
        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public void deleteHotel(String id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel Not Found with Id : "+id));
        hotelRepository.delete(hotel);
    }

    @Override
    public HotelDto updateHotel(String id, HotelDto hotelDto) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel Not Found with Id : "+id));
        hotel.setAbout(hotelDto.getAbout());
        hotel.setName(hotelDto.getName());
        hotel.setLocation(hotelDto.getLocation());
        return modelMapper.map(hotelRepository.save(hotel),HotelDto.class);
    }
}
