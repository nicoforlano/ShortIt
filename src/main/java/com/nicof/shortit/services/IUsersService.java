package com.nicof.shortit.services;

import com.nicof.shortit.dtos.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUsersService {

    Mono<UserDto> registerUser(UserDto userDto);
    Flux<UserDto> getUsers();
}
