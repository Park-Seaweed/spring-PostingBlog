package com.sparta.hanghae99homework.controller;

import com.sparta.hanghae99homework.domain.model.Post;
import com.sparta.hanghae99homework.dto.request.PostRequestDto;
import com.sparta.hanghae99homework.dto.response.PostResponseDto;
import com.sparta.hanghae99homework.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto postRequestDto){
        return postService.createPost(postRequestDto);
    }
    @GetMapping("/api/posts")
    public List<PostResponseDto> readPost(){
        return postService.readPost();
    }

    @DeleteMapping("/api/posts/{postId}")
    public void deletePost(@PathVariable Long postId){
        postService.deletePost(postId);
    }

    @PutMapping("/api/posts/{postId}")
    public Long updatePost(@PathVariable Long postId,@RequestBody PostRequestDto postRequestDto){
        postService.update(postId, postRequestDto);
        return postId;
    }
}
