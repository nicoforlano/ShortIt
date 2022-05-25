package com.nicof.shortit.services.impl;

import com.nicof.shortit.dtos.UserDto;
import com.nicof.shortit.mappers.UsersMapper;
import com.nicof.shortit.models.User;
import com.nicof.shortit.repositories.UserRepository;
import com.nicof.shortit.services.IUsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class UsersService implements IUsersService {

    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Mono<UserDto> registerUser(UserDto userDto) {
        log.debug("Registering user");

        User user = UsersMapper.dtoToUser(userDto);
        user.setAccountConfirmationToken(
                UUID.nameUUIDFromBytes(userDto.getUsername().getBytes(StandardCharsets.UTF_8)
                ).toString());
        user.setConfirmed(false);
        user.setCreatedDate(LocalDateTime.now());
        //TODO:
        return userRepository.save(user)
                .map(UsersMapper::userToDto);
    }

    @Override
    public Flux<UserDto> getUsers() {
        return userRepository.findAll()
                .map(UsersMapper::userToDto);
    }
}
