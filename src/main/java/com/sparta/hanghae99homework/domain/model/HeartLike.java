package com.sparta.hanghae99homework.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class HeartLike {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn
    private Users users;

    @ManyToOne
    @JoinColumn
    private Post post;

    @ManyToOne
    @JoinColumn
    private Comment comment;

    @ManyToOne
    @JoinColumn
    private Commit commit;

    public HeartLike(Users users,Post post){
        this.users = users;
        this.post = post;
    }

    public HeartLike(Users users,Comment comment){
        this.users = users;
        this.comment = comment;
    }

    public HeartLike(Users users, Commit commit){
        this.users = users;
        this.commit = commit;
    }




}
