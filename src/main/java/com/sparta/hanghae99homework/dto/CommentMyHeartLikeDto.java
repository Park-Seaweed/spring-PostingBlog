package com.sparta.hanghae99homework.dto;

import com.sparta.hanghae99homework.domain.model.Comment;
import com.sparta.hanghae99homework.domain.model.Post;
import lombok.Getter;

@Getter
public class CommentMyHeartLikeDto {
    private String userWriter;
    private int like;

    public CommentMyHeartLikeDto (Comment comment){
        this.userWriter = comment.getUserWriter();
        this.like = comment.getLikeCount();
    }
}
