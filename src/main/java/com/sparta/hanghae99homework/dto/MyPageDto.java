package com.sparta.hanghae99homework.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MyPageDto {
    private final List<PostMyDto> postMyDtoList = new ArrayList<>();
    private final List<CommentMyDto> commentMyDtoList = new ArrayList<>();
    private final List<CommitMyDto> commitMyDtoList = new ArrayList<>();
    private final List<PostMyHeartLikeDto> postMyHeartLikeDtoList = new ArrayList<>();
    private final List<CommentMyHeartLikeDto> commentMyHeartLikeDtoList = new ArrayList<>();
    private final List<CommitMyHeartLikeDto> commitMyHeartLikeDtoList = new ArrayList<>();

    public void addPostMyDtoList(PostMyDto postMyDto){
        this.postMyDtoList.add(postMyDto);
    }

    public void addCommentMyDtoList(CommentMyDto commentMyDto){
        this.commentMyDtoList.add(commentMyDto);
    }

    public void addCommitMyDtoList(CommitMyDto commitMyDto){
        this.commitMyDtoList.add(commitMyDto);
    }

    public void addPostMyDtoList(PostMyHeartLikeDto postMyHeartLikeDto){
        this.postMyHeartLikeDtoList.add(postMyHeartLikeDto);
    }

    public void addCommentMyDtoList(CommentMyHeartLikeDto commentMyHeartLikeDto){
        this.commentMyHeartLikeDtoList.add(commentMyHeartLikeDto);
    }

    public void addCommitMyDtoList(CommitMyHeartLikeDto commitMyHeartLikeDto){
        this.commitMyHeartLikeDtoList.add(commitMyHeartLikeDto);
    }

}
