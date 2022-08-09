package com.sparta.hanghae99homework.dto.response;

import com.sparta.hanghae99homework.domain.model.Comment;
import com.sparta.hanghae99homework.domain.model.Commit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommitResponseDto {
    private Long id;
    private String userWriter;
    private String content;

    public CommitResponseDto (Commit commit){
        this.id = commit.getId();
        this.userWriter = commit.getUserWriter();
        this.content = commit.getContent();
    }
}
