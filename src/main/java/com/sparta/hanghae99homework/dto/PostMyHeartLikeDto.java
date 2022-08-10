package com.sparta.hanghae99homework.dto;

import com.sparta.hanghae99homework.domain.model.Comment;
import com.sparta.hanghae99homework.domain.model.Commit;
import com.sparta.hanghae99homework.domain.model.Post;
import com.sparta.hanghae99homework.domain.model.Users;
import lombok.Getter;


@Getter
public class PostMyHeartLikeDto {

    private String userWriter;
    private String title;
    private int like;

    public PostMyHeartLikeDto (Post post){
        this.userWriter = post.getUserWriter();
        this.title = post.getTitle();
        this.like = post.getLikeCount();
    }
}
