package com.hotel.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {
    private String id;
    private  String name;
    private  String location;
    private  String about;
}
