package com.sparta.hanghae99homework.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommitRequestDto {
    private String userWriter;
    private String content;
    private int likes;
}
