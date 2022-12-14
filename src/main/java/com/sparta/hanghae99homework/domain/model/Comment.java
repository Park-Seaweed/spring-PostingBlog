package com.sparta.hanghae99homework.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sparta.hanghae99homework.dto.request.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Comment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String userWriter;

    @Column(nullable = false)
    private String content;

    private int likeCount;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "USERS_ID")
    private Users users;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "POST_ID")
    private Post post;

    @OneToMany
    @JsonManagedReference
    private List<Commit> commitList = new ArrayList<>();

    @OneToMany(mappedBy = "comment")
    @JsonIgnore
    private List<HeartLike> heartLikeList = new ArrayList<>();



    public Comment(CommentRequestDto commentRequestDto, Users users, Post post){
        this.userWriter = commentRequestDto.getUserWriter();
        this.content = commentRequestDto.getContent();
        this.users = users;
        this.post = post;

    }

    public void update(CommentRequestDto commentRequestDto) {
        this.content = commentRequestDto.getContent();
    }

    public void addCommit(Commit commit) {
        this.commitList.add(commit);
    }

    public void deleteCommit(Commit commit) {
        this.commitList.remove(commit);
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
