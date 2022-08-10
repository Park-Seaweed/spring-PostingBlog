package com.sparta.hanghae99homework.repository;

import com.sparta.hanghae99homework.domain.model.Commit;
import com.sparta.hanghae99homework.domain.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommitRepository extends JpaRepository<Commit, Long> {
    List<Commit> findAllByUsers(Users user);
}
