package com.cherry.blogging.service;

import com.cherry.blogging.dto.UserDto;
import com.cherry.blogging.entity.User;
import com.cherry.blogging.execption.ResourceNotFoundException;
import com.cherry.blogging.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.userDtoToUser(userDto);
        User savedUser = userRepo.save(user);
        return this.userToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(int userId) {
        User userFetched = getUserDetails(userId);
        return  this.userToUserDto(userFetched);
    }

    @Override
    public UserDto updateUser(UserDto userDto, int userId) {
        User userFetched = getUserDetails(userId);
        userFetched.setFirstName(userDto.getFirstName());
        userFetched.setLastName(userDto.getLastName());
        userFetched.setEmail(userDto.getEmail());
        userFetched.setAbout(userDto.getAbout());
        userFetched.setPassword(userDto.getPassword());
        return this.userToUserDto(this.userRepo.save(userFetched));
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        return users.stream().map(this::userToUserDto).collect(Collectors.toList());
    }

    @Override
    public void deleteUser(int userId) {
        User user = this.getUserDetails(userId);
        this.userRepo.delete(user);

    }

    private User getUserDetails(int userId){
        return this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User","UserId",userId));
    }

    private User userDtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        return  user;
    }

    private UserDto userToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setAbout(user.getAbout());
        userDto.setPassword(user.getPassword());
        return  userDto;
    }
}
