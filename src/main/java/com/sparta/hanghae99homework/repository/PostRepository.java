package com.sparta.hanghae99homework.repository;

import com.sparta.hanghae99homework.domain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
}
