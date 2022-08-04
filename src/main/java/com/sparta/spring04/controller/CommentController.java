package com.sparta.spring04.controller;

import com.sparta.spring04.dto.CommentRequestDto;
import com.sparta.spring04.dto.ResponseDto;
import com.sparta.spring04.model.User;
import com.sparta.spring04.security.UserDetailsImpl;
import com.sparta.spring04.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;
/*
    @PostMapping("/api/auth/comment")
    public ResponseDto<?> postBoard(@RequestBody CommentRequestDto commentRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        User user = userDetails.getUser();
        return commentService.postComment(commentRequestDto, user);
    }

 */
}
