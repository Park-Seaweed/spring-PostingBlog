package com.sparta.hanghae99homework.dto.request;

import com.sparta.hanghae99homework.domain.model.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter

public class PostRequestDto {
    private String userWriter;
    private String title;
    private String content;
    private int like;
    private String filePath;


}
