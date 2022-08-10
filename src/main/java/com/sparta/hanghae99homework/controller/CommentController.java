package com.sparta.hanghae99homework.controller;

import com.sparta.hanghae99homework.domain.model.Comment;
import com.sparta.hanghae99homework.dto.request.CommentRequestDto;
import com.sparta.hanghae99homework.dto.request.PostRequestDto;
import com.sparta.hanghae99homework.dto.response.CommentResponseDto;
import com.sparta.hanghae99homework.dto.response.PostResponseDto;
import com.sparta.hanghae99homework.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/api/{postId}/comments")
    public Comment createComment(@PathVariable Long postId,
                                 @RequestBody CommentRequestDto commentRequestDto){
        return commentService.createComment(postId,commentRequestDto);
    }

    @GetMapping("/api/comments")
    public List<CommentResponseDto> readComment(){
        return commentService.readComment();
    }

    @DeleteMapping("/api/{postId}/{commentId}")
    public void deletePost(
            @PathVariable Long postId,
            @PathVariable Long commentId){
        commentService.deleteComment(postId,commentId);
    }
    @PutMapping("/api/comments/{commentId}")
    public Long updateComment(@PathVariable Long commentId,@RequestBody CommentRequestDto commentRequestDto){
        commentService.update(commentId, commentRequestDto);
        return commentId;
    }
    @PostMapping("/comment/{commentId}/like")
    public void heartLikes(@PathVariable Long commentId,@RequestBody CommentRequestDto commentRequestDto){
        commentService.commentLike(commentId, commentRequestDto.getUserWriter());
    }
}
