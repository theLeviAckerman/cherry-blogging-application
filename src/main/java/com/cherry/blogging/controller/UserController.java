package com.cherry.blogging.controller;

import com.cherry.blogging.dto.UserDto;
import com.cherry.blogging.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto createdUser = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/fetch/{userId}")
    public ResponseEntity<UserDto> fetchUser(@PathVariable int userId){
        UserDto fetchedUser = this.userService.getUserById(userId);
        return new ResponseEntity<>(fetchedUser, HttpStatus.OK);
    }
}
