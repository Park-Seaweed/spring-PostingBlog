package com.sparta.hanghae99homework.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Users extends Timestamped {
    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany
    @JsonManagedReference
    private List<Post> postList = new ArrayList<>();

    @OneToMany
    @JsonManagedReference
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany
    @JsonManagedReference
    private List<Commit> commitList = new ArrayList<>();

    public Users(String username, String password){
        this.username = username;
        this.password = password;
    }
    public void addPost(Post post){
        this.postList.add(post);
    }
    public void deletePost(Post post){
        this.postList.remove(post);
    }

    public void addComment(Comment comment) {
        this.commentList.add(comment);
    }

    public void deleteComment(Comment comment) {
        this.commentList.remove(comment);
    }

    public void addCommit(Commit commit) {
        this.commitList.add(commit);
    }

    public void deleteCommit(Commit commit) {
        this.commitList.remove(commit);
    }
}
