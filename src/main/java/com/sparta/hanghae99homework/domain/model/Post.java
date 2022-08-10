package com.sparta.hanghae99homework.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sparta.hanghae99homework.dto.request.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Entity
public class Post {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = true)
    private String userWriter;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(columnDefinition = "TEXT")
    private String filePath;

    private int likeCount;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "USERS_ID")
    private Users users;



    @OneToMany
    @JsonManagedReference
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<HeartLike> heartLikeList = new ArrayList<>();





    public Post(PostRequestDto postRequestDto, Users users) {
        this.userWriter = postRequestDto.getUserWriter();
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.filePath = postRequestDto.getFilePath();
        this.users = users;
    }


    public void update(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
    }

    public void addComment(Comment comment) {
        this.commentList.add(comment);
    }

    public void deleteComment(Comment comment) {
        this.commentList.remove(comment);
    }

    public void addHeartLike(HeartLike heartLike) {
        this.heartLikeList.add(heartLike);
    }

    public void removeHeartLike(HeartLike heartLike) {
        this.heartLikeList.remove(heartLike);
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
