package com.sparta.hanghae99homework.dto;

import com.sparta.hanghae99homework.domain.model.Comment;
import lombok.Getter;

@Getter
public class CommentMyDto {
    private String userWriter;
    private String content;

    public CommentMyDto (Comment comment){

        this.userWriter = comment.getUserWriter();
        this.content = comment.getContent();
    }
}
