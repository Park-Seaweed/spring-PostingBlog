package com.sparta.hanghae99homework.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class PostRequestDto {
    private String userWriter;
    private String title;
    private String content;
    private int like;
}
