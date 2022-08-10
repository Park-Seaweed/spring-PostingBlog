package com.sparta.hanghae99homework.controller;

import com.sparta.hanghae99homework.S3Uploader;
import com.sparta.hanghae99homework.domain.model.Post;
import com.sparta.hanghae99homework.dto.request.PostRequestDto;
import com.sparta.hanghae99homework.dto.response.PostResponseDto;
import com.sparta.hanghae99homework.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;
    private final S3Uploader s3Uploader;

//    @PostMapping("/api/posts")
//    public Post createPost(@RequestBody PostRequestDto postRequestDto){
//        return postService.createPost(postRequestDto);
//    }
    @PostMapping("/gallery")
    public Post execWrite(PostRequestDto postRequestDto, MultipartFile multipartFile) throws IOException {
        String imgPath = s3Uploader.upload(multipartFile,"static");
        postRequestDto.setFilePath(imgPath);
        return postService.savePost(postRequestDto);
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
    @PostMapping("/pots/{postId}/like")
    public void heartLikes(@PathVariable Long postId, PostRequestDto postRequestDto){
        postService.postLike(postId, postRequestDto.getUserWriter());
    }

}
