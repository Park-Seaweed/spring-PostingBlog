package com.sparta.hanghae99homework.service;

import com.sparta.hanghae99homework.domain.model.Comment;
import com.sparta.hanghae99homework.domain.model.Commit;
import com.sparta.hanghae99homework.domain.model.Post;
import com.sparta.hanghae99homework.domain.model.Users;
import com.sparta.hanghae99homework.dto.request.CommentRequestDto;
import com.sparta.hanghae99homework.dto.request.CommitRequestDto;
import com.sparta.hanghae99homework.dto.response.CommentResponseDto;
import com.sparta.hanghae99homework.dto.response.CommitResponseDto;
import com.sparta.hanghae99homework.repository.CommentRepository;
import com.sparta.hanghae99homework.repository.CommitRepository;
import com.sparta.hanghae99homework.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommitService {

    private final CommentRepository commentRepository;
    private final UsersRepository usersRepository;
    private final CommitRepository commitRepository;
    public Commit createCommit(Long commentId, CommitRequestDto commitRequestDto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        Users users = usersRepository.findById(commitRequestDto.getUserWriter())
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        Commit commit = new Commit(commitRequestDto, users ,comment);

        comment.addCommit(commit);
        users.addCommit(commit);

        return commitRepository.save(commit);
    }

    public List<CommitResponseDto> readCommit() {
        List<Commit> commits = commitRepository.findAll();
        List<CommitResponseDto> commitResponseDtoList = new ArrayList<>();
        for(Commit commit: commits){
            commitResponseDtoList.add(new CommitResponseDto(commit));
        }
        return commitResponseDtoList;
    }

    public void deleteCommit(Long commentId, Long commitId) {
        Commit commit = commitRepository.findById(commitId)
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        Users users = usersRepository.findById(commit.getUsers().getUsername())
                .orElseThrow(()-> new IllegalArgumentException("아이디가 없습니다"));
        comment.deleteCommit(commit);
        users.deleteCommit(commit);
        commitRepository.delete(commit);
    }

    @Transactional
    public Long update(Long commitId, CommitRequestDto commitRequestDto) {
        Commit commit = commitRepository.findById(commitId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        commit.update(commitRequestDto);
        return commitId;
    }
}
