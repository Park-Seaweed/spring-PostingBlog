package com.sparta.hanghae99homework.repository;

import com.sparta.hanghae99homework.domain.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,String> {
//    List<Users> findAllByOrderByModifiedAtDesc();

}
