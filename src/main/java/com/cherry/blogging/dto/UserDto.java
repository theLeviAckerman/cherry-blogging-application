package com.cherry.blogging.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {
    private int id;

    @NotEmpty
    @Size(min = 4, message = "UserName must be atleast 4 characters ")
    private String firstName;

    private String lastName;

    @Email(message = "Email should be Valid")
    private String email;

    @Size(min = 10, max = 1024,message = "About should be between 10 to 1024 Characters")
    private String about;


    @NotEmpty
    @Size(min = 8,max = 28, message = "Password should be between 8 to 28 characters")
    private String password;

}
