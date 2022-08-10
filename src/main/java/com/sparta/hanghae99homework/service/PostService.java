package com.sparta.hanghae99homework.service;

import com.sparta.hanghae99homework.domain.model.HeartLike;
import com.sparta.hanghae99homework.domain.model.Post;
import com.sparta.hanghae99homework.domain.model.Users;
import com.sparta.hanghae99homework.dto.request.PostRequestDto;
import com.sparta.hanghae99homework.dto.response.PostResponseDto;
import com.sparta.hanghae99homework.repository.HeartLikeRepository;
import com.sparta.hanghae99homework.repository.PostRepository;
import com.sparta.hanghae99homework.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UsersRepository usersRepository;
    private final HeartLikeRepository heartLikeRepository;
//    public Post createPost(PostRequestDto postRequestDto) {
//
//        Users users = usersRepository.findById(postRequestDto.getUserWriter())
//                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
//        Post post = new Post(postRequestDto, users);
//
//        users.addPost(post);
//
//        return postRepository.save(post);
//    }
    public Post savePost(PostRequestDto postRequestDto) {
        Users users = usersRepository.findById(postRequestDto.getUserWriter())
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        Post post = new Post(postRequestDto, users);
        users.addPost(post);
        postRepository.save(post);
        return post;
    }



    public List<PostResponseDto> readPost() {
        List<Post> posts = postRepository.findAll();
        List<PostResponseDto> postResponseDtoList = new ArrayList<>();
        for(Post post : posts){
            postResponseDtoList.add(new PostResponseDto(post));
        }
        return postResponseDtoList;
    }


    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        Users users = usersRepository.findById(post.getUsers().getUsername())
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        users.deletePost(post);
        postRepository.delete(post);

    }
    @Transactional
    public Long update(Long postId, PostRequestDto postRequestDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
        post.update(postRequestDto);
        return postId;
    }

    public void postLike(Long postId, String userWriter) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
        Users users = usersRepository.findById(userWriter)
                .orElseThrow(() -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
        if (heartLikeRepository.findByPostAndUsers(post,users) == null){
            HeartLike heartLike = new HeartLike(users,post);
            users.addHeartLike(heartLike);
            post.addHeartLike(heartLike);
            post.setLikeCount(post.getHeartLikeList().size());
            heartLikeRepository.save(heartLike);
        }else {
            HeartLike byPostAndUsers = heartLikeRepository.findByPostAndUsers(post, users);
            users.removeHeartLike(byPostAndUsers);
            post.removeHeartLike(byPostAndUsers);
            post.setLikeCount(post.getHeartLikeList().size());
            heartLikeRepository.delete(byPostAndUsers);
        }

    }
}
