package com.user.service.api.service;

import com.user.service.api.dto.UserDto;
import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto user);
    List<UserDto> getAllUser();
    UserDto getUser(String userId);
    UserDto updateUser(String userId,UserDto userDto);
    void deleteUser(String userId);
}
