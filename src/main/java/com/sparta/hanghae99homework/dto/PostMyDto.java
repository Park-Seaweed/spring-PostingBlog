package com.sparta.hanghae99homework.dto;

import com.sparta.hanghae99homework.domain.model.Post;
import lombok.Getter;

@Getter
public class PostMyDto {

    private String userWriter;
    private String title;


    public PostMyDto (Post post){
        this.userWriter = post.getUserWriter();
        this.title = post.getTitle();
    }
}
