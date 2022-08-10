package com.sparta.hanghae99homework.dto.request;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class PostRequestDto {
    private String userWriter;
    private String title;
    private String content;
    private int like;
    private String filePath;


}
