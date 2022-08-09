package com.sparta.hanghae99homework.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sparta.hanghae99homework.dto.request.CommitRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    private int likes;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "USERS_ID")
    private Users users;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "COMMENT_ID")
    private Comment comment;

    public Commit(CommitRequestDto commitRequestDto, Users users, Comment comment){
        this.userWriter = commitRequestDto.getUserWriter();
        this.content = commitRequestDto.getContent();
        this.likes = commitRequestDto.getLikes();
        this.users = users;
        this.comment = comment;

    }

    public void update(CommitRequestDto commitRequestDto) {
        this.content = commitRequestDto.getContent();
    }
}
