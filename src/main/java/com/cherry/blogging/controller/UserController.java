package com.cherry.blogging.controller;

import com.cherry.blogging.dto.CommonApiResponse;
import com.cherry.blogging.dto.UserDto;
import com.cherry.blogging.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createdUser = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/fetch/{userId}")
    public ResponseEntity<UserDto> fetchUser(@PathVariable Integer userId) {
        UserDto fetchedUser = this.userService.getUserById(userId);
        return new ResponseEntity<>(fetchedUser, HttpStatus.OK);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId) {
        UserDto updatedUser = this.userService.updateUser(userDto, userId);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> allUsers = this.userService.getAllUsers();

       return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userID}")
    public ResponseEntity<CommonApiResponse> deleteUser(@PathVariable("userID") Integer userId){
        this.userService.deleteUser(userId);
        CommonApiResponse commonApiResponse = new CommonApiResponse("User Deleted Successfully", true, HttpStatus.OK);

        return new ResponseEntity<>(commonApiResponse, HttpStatus.OK);

    }



}
