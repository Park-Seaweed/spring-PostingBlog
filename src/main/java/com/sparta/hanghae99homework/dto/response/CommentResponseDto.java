package com.sparta.hanghae99homework.dto.response;

import com.sparta.hanghae99homework.domain.model.Comment;
import com.sparta.hanghae99homework.domain.model.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponseDto {
    private Long id;
    private String userWriter;
    private String content;

    public CommentResponseDto (Comment comment){
        this.id = comment.getId();
        this.userWriter = comment.getUserWriter();
        this.content = comment.getContent();
    }
}
