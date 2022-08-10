package com.sparta.hanghae99homework.dto;

import com.sparta.hanghae99homework.domain.model.Commit;
import lombok.Getter;

@Getter
public class CommitMyDto {

    private String userWriter;
    private String content;

    public CommitMyDto (Commit commit){
        this.userWriter = commit.getUserWriter();
        this.content = commit.getContent();
    }
}
