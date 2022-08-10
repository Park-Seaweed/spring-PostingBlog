package com.sparta.hanghae99homework.service;

import com.sparta.hanghae99homework.domain.model.*;
import com.sparta.hanghae99homework.dto.*;
import com.sparta.hanghae99homework.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MyPageService {

    private final UsersRepository usersRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final CommitRepository commitRepository;
    private final HeartLikeRepository heartLikeRepository;

    public MyPageDto readMaPage(String usersId) {
        MyPageDto myPageDto = new MyPageDto();
        Users user = usersRepository.findById(usersId)
                .orElseThrow(() -> new NullPointerException("존재하지 않는 사용자입니다."));
        List<Post> postList = postRepository.findAllByUsers(user);
        List<Comment> commentList = commentRepository.findAllByUsers(user);
        List<Commit> commitList = commitRepository.findAllByUsers(user);
        List<HeartLike> postIsNotNullList = heartLikeRepository.findByUsersAndPostIsNotNull(user);
        List<HeartLike> commentIsNotNullList = heartLikeRepository.findByUsersAndCommentIsNotNull(user);
        List<HeartLike> commitIsNotNullList = heartLikeRepository.findByUsersAndCommitIsNotNull(user);

        for(Post post : postList){
            myPageDto.addPostMyDtoList(new PostMyDto(post));
        }
        for(Comment comment : commentList){
            myPageDto.addCommentMyDtoList(new CommentMyDto(comment));
        }
        for(Commit commit : commitList){
            myPageDto.addCommitMyDtoList(new CommitMyDto(commit));
        }
        for (HeartLike likePost : postIsNotNullList) {
            myPageDto.addPostMyDtoList(new PostMyHeartLikeDto(likePost.getPost()));
        }
        for (HeartLike likesComment : commentIsNotNullList) {
            myPageDto.addCommentMyDtoList(new CommentMyHeartLikeDto(likesComment.getComment()));
        }
        for (HeartLike likesCommit : commitIsNotNullList) {
            myPageDto.addCommitMyDtoList(new CommitMyHeartLikeDto(likesCommit.getCommit()));
        }

        return myPageDto;
    }
}
