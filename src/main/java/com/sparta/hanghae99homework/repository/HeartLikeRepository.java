package com.sparta.hanghae99homework.repository;

import com.sparta.hanghae99homework.domain.model.HeartLike;
import com.sparta.hanghae99homework.domain.model.Post;
import com.sparta.hanghae99homework.domain.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeartLikeRepository extends JpaRepository<HeartLike, Long> {
    HeartLike findByPostAndUsers(Post post, Users users);
}
