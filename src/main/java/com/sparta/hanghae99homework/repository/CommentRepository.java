package com.sparta.hanghae99homework.repository;

import com.sparta.hanghae99homework.domain.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
