package com.sparta.hanghae99homework.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sparta.hanghae99homework.dto.request.CommitRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Commit {
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
    @JoinColumn(name = "COMMENT_ID")
    private Comment comment;

    @OneToMany(mappedBy = "commit")
    @JsonIgnore
    private List<HeartLike> heartLikeList = new ArrayList<>();



    public Commit(CommitRequestDto commitRequestDto, Users users, Comment comment){
        this.userWriter = commitRequestDto.getUserWriter();
        this.content = commitRequestDto.getContent();
        this.users = users;
        this.comment = comment;

    }

    public void update(CommitRequestDto commitRequestDto) {
        this.content = commitRequestDto.getContent();
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
