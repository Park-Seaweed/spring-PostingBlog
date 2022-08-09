package com.sparta.hanghae99homework.controller;

import com.sparta.hanghae99homework.domain.model.Users;
import com.sparta.hanghae99homework.dto.request.SignupRequestDto;
import com.sparta.hanghae99homework.repository.UsersRepository;
import com.sparta.hanghae99homework.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RequiredArgsConstructor
@RestController
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/users/signup")
    public Users registerUser(@RequestBody SignupRequestDto requestDto) {
        return usersService.registerUser(requestDto);
    }

    @GetMapping("/users/signup/{username}")
    public Optional<Users> readUser(@PathVariable String username){
        return usersService.readUser(username);
    }

}
