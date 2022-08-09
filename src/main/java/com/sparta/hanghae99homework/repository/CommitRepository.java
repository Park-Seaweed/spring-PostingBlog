package com.sparta.hanghae99homework.repository;

import com.sparta.hanghae99homework.domain.model.Commit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitRepository extends JpaRepository<Commit, Long> {
}
