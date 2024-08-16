package com.cherry.blogging.service;

import com.cherry.blogging.dto.UserDto;
import com.cherry.blogging.entity.User;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(int userId);

    UserDto updateUser(UserDto userDto, int userID);

    List<UserDto> getAllUsers();

    void deleteUser(int userId);


}
