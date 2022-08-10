package com.sparta.hanghae99homework.service;

import com.sparta.hanghae99homework.domain.model.Comment;
import com.sparta.hanghae99homework.domain.model.HeartLike;
import com.sparta.hanghae99homework.domain.model.Post;
import com.sparta.hanghae99homework.domain.model.Users;
import com.sparta.hanghae99homework.dto.request.CommentRequestDto;
import com.sparta.hanghae99homework.dto.response.CommentResponseDto;
import com.sparta.hanghae99homework.repository.CommentRepository;
import com.sparta.hanghae99homework.repository.HeartLikeRepository;
import com.sparta.hanghae99homework.repository.PostRepository;
import com.sparta.hanghae99homework.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final UsersRepository usersRepository;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final HeartLikeRepository heartLikeRepository;
    public Comment createComment(Long postId, CommentRequestDto commentRequestDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        Users users = usersRepository.findById(commentRequestDto.getUserWriter())
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        Comment comment = new Comment(commentRequestDto, users,post);

        post.addComment(comment);
        users.addComment(comment);

        return commentRepository.save(comment);
    }


    public List<CommentResponseDto> readComment() {
        List<Comment> comments = commentRepository.findAll();
        List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();
        for(Comment comment: comments){
            commentResponseDtoList.add(new CommentResponseDto(comment));
        }
        return commentResponseDtoList;
    }

    public void deleteComment(Long postId, Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        Users users = usersRepository.findById(comment.getUsers().getUsername())
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        users.deleteComment(comment);
        post.deleteComment(comment);
        commentRepository.delete(comment);
    }
    @Transactional
    public Long update(Long commentId, CommentRequestDto commentRequestDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        comment.update(commentRequestDto);
        return commentId;
    }

    public void commentLike(Long commentId, String userWriter) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
        Users users = usersRepository.findById(userWriter)
                .orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
        if (heartLikeRepository.findByCommentAndUsers(comment,users) == null){
            HeartLike heartLike = new HeartLike(users,comment);
            users.addHeartLike(heartLike);
            comment.addHeartLike(heartLike);
            comment.setLikeCount(comment.getHeartLikeList().size());
            heartLikeRepository.save(heartLike);
        }else {
            HeartLike byCommentAndUsers = heartLikeRepository.findByCommentAndUsers(comment, users);
            users.removeHeartLike(byCommentAndUsers);
            comment.removeHeartLike(byCommentAndUsers);
            comment.setLikeCount(comment.getHeartLikeList().size());
            heartLikeRepository.delete(byCommentAndUsers);
        }
    }
}
