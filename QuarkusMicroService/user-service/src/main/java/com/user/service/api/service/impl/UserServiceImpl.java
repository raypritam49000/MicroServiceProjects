package com.user.service.api.service.impl;

import com.user.service.api.client.HotelClient;
import com.user.service.api.client.RatingClient;
import com.user.service.api.dto.HotelDto;
import com.user.service.api.dto.RatingDto;
import com.user.service.api.dto.UserDto;
import com.user.service.api.entity.User;
import com.user.service.api.exceptions.ResourceNotFoundException;
import com.user.service.api.repository.UserRepository;
import com.user.service.api.service.UserService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Inject
    private ModelMapper modelMapper;

    @Inject
    @RestClient
    private RatingClient ratingClient;

    @Inject
    @RestClient
    private HotelClient hotelClient;


    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return this.modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = userList.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return userDtoList;
    }

    @Override
    public UserDto getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found with Id : " + userId));
        UserDto userDto = modelMapper.map(user, UserDto.class);
        List<RatingDto> ratingDtos = ratingClient.getAllRatingsByUserId(user.getUserId());

        List<RatingDto> ratingDtosList = ratingDtos.stream().map(ratingDto -> {
            HotelDto hotelDto = hotelClient.getHotel(ratingDto.getHotelId());
            ratingDto.setHotelDto(hotelDto);
            return ratingDto;
        }).collect(Collectors.toList());

        userDto.setRatings(ratingDtosList);
        return userDto;
    }

    @Override
    public UserDto updateUser(String userId, UserDto userDto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found with Id : " + userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        User updatedUser = userRepository.save(user);
        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found with Id : " + userId));
        this.userRepository.delete(user);
    }
}
