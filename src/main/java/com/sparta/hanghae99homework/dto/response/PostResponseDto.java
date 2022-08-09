package com.sparta.hanghae99homework.dto.response;

import com.sparta.hanghae99homework.domain.model.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponseDto {
    private Long id;
    private String userWriter;
    private String title;

    public PostResponseDto (Post post){
        this.id = post.getId();
        this.userWriter = post.getUserWriter();
        this.title = post.getTitle();
    }
}
