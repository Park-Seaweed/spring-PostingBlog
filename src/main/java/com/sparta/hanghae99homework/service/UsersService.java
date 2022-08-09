package com.sparta.hanghae99homework.service;

import com.sparta.hanghae99homework.domain.model.Users;
import com.sparta.hanghae99homework.dto.request.SignupRequestDto;
import com.sparta.hanghae99homework.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public Users registerUser(SignupRequestDto requestDto) {
        String username = requestDto.getUsername();

        Optional<Users> found = usersRepository.findById(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }
        String password = requestDto.getPassword();
        Users users = new Users(username,password);


        return usersRepository.save(users);
    }

    public Optional<Users> readUser(String username) {
        return usersRepository.findById(username);
    }
}


