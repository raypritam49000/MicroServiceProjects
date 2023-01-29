package com.user.service.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String userId;
    private String name;
    private String about;
    private String email;
    private List<RatingDto> ratings = new ArrayList<RatingDto>();
}
