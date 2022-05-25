package com.nicof.shortit.controllers;

import com.nicof.shortit.dtos.UserDto;
import com.nicof.shortit.services.IUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import javax.validation.Valid;

@Slf4j
@RequestMapping(path = "/users")
@RestController
public class UsersController {

    private final IUsersService usersService;

    public UsersController(IUsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        log.debug(String.format("User: %s", userDto));
        return usersService.registerUser(userDto);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<UserDto> getUsers() {
        log.debug("Getting users");
        return usersService.getUsers();
    }
}
