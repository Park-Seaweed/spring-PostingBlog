package com.sparta.hanghae99homework.dto;

import com.sparta.hanghae99homework.domain.model.Comment;
import com.sparta.hanghae99homework.domain.model.Commit;
import lombok.Getter;

@Getter
public class CommitMyHeartLikeDto {
    private String userWriter;
    private int like;

    public CommitMyHeartLikeDto (Commit commit){
        this.userWriter = commit.getUserWriter();
        this.like = commit.getLikeCount();
    }
}
