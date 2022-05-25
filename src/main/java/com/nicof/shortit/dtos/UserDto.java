package com.nicof.shortit.dtos;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    @Length(min = 4,message = "Username must be at least 4 characters long")
    @NotNull(message = "User's name can´t be null")
    private String username;

    @Email(message = "Email is invalid")
    @NotEmpty(message = "User's email can´t be empty")
    @NotNull(message = "User's name can´t be null")
    private String email;

    @Length(min = 8,message = "Password must be at least 8 characters long")
    @NotNull(message = "User's password can´t be null")
    private String password;

}
