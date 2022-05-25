package com.nicof.shortit.mappers;

import com.nicof.shortit.dtos.UserDto;
import com.nicof.shortit.models.User;

public class UsersMapper {

    public static User dtoToUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        return user;
    }

    public static UserDto userToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
