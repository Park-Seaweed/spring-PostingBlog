package com.sparta.hanghae99homework.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sparta.hanghae99homework.dto.request.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Post {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String userWriter;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private int likes;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "USERS_ID")
    private Users users;

    @OneToMany
    @JsonManagedReference
    private List<Comment> commentList = new ArrayList<>();


    public Post(PostRequestDto postRequestDto, Users users) {
        this.userWriter = postRequestDto.getUserWriter();
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.likes = postRequestDto.getLike();
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
}
