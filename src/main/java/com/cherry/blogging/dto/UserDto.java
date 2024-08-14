package com.cherry.blogging.dto;


import jakarta.persistence.Column;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String about;

    private String password;

}
