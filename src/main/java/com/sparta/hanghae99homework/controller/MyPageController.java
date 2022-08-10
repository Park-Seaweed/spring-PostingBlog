package com.sparta.hanghae99homework.controller;

import com.sparta.hanghae99homework.dto.MyPageDto;
import com.sparta.hanghae99homework.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyPageController {
    private final MyPageService myPageService;

    @GetMapping("/mypage/{usersId}")
    public MyPageDto readMyPage(@PathVariable String usersId){
        return myPageService.readMaPage(usersId);
    }
}
