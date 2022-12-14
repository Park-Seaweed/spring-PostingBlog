//package com.sparta.hanghae99homework.controller;
//
//import com.sparta.hanghae99homework.S3Uploader;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
//@RequiredArgsConstructor
//@RestController
//public class HelloController {
//
//    private final S3Uploader s3Uploader;
//
//    @PostMapping("/upload")
//    @ResponseBody
//    public String upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
//        return s3Uploader.upload(multipartFile, "static");
//    }
//
//}