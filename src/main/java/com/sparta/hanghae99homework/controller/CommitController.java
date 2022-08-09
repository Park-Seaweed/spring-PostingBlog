package com.sparta.hanghae99homework.controller;

import com.sparta.hanghae99homework.domain.model.Comment;
import com.sparta.hanghae99homework.domain.model.Commit;
import com.sparta.hanghae99homework.dto.request.CommentRequestDto;
import com.sparta.hanghae99homework.dto.request.CommitRequestDto;
import com.sparta.hanghae99homework.dto.response.CommentResponseDto;
import com.sparta.hanghae99homework.dto.response.CommitResponseDto;
import com.sparta.hanghae99homework.service.CommitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommitController {

    private final CommitService commitService;
    @PostMapping("/api/{commentId}/commit")
    public Commit createCommit(@PathVariable Long commentId,
                               @RequestBody CommitRequestDto commitRequestDto){
        return commitService.createCommit(commentId,commitRequestDto);
    }
    @GetMapping("/api/commits")
    public List<CommitResponseDto> readCommit(){
        return commitService.readCommit();
    }

    @DeleteMapping("/api/commit/{commentId}/{commitId}")
    public void deleteCommit(
            @PathVariable Long commentId,
            @PathVariable Long commitId){
        commitService.deleteCommit(commentId, commitId);
    }
    @PutMapping("/api/commit/{commitId}")
    public Long updateCommit(
            @PathVariable Long commitId,
            @RequestBody CommitRequestDto commitRequestDto){
        commitService.update(commitId, commitRequestDto);
        return commitId;
    }
}
