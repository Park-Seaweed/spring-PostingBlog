package com.sparta.hanghae99homework.repository;

import com.sparta.hanghae99homework.domain.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeartLikeRepository extends JpaRepository<HeartLike, Long> {
    HeartLike findByPostAndUsers(Post post, Users users);
    HeartLike findByCommentAndUsers(Comment comment, Users users);
    HeartLike findByCommitAndUsers(Commit commit, Users users);
    List<HeartLike> findByUsersAndPostIsNotNull(Users user);
    List<HeartLike> findByUsersAndCommentIsNotNull(Users user);
    List<HeartLike> findByUsersAndCommitIsNotNull(Users user);
}
