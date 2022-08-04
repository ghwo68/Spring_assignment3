package com.sparta.spring04.controller;

import com.sparta.spring04.dto.BoardRequestDto;
import com.sparta.spring04.dto.ResponseDto;
import com.sparta.spring04.model.User;
import com.sparta.spring04.security.UserDetailsImpl;
import com.sparta.spring04.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

/*
    @PostMapping("/api/auth/post")
    public ResponseDto<?> postBoard(@RequestBody BoardRequestDto boardRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        User user = userDetails.getUser();
        return boardService.postBoard(boardRequestDto,user);
    }
*/
    //게시글 작성
    @PostMapping("/api/auth/post")
    public ResponseDto<?> postBoard(@RequestBody BoardRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails ){
        return boardService.postBoard(requestDto, userDetails);
        }

    //게시글 조회
    @GetMapping("/api/post")
    public ResponseDto<?> getBoard(){
        return boardService.getBoard();
    }

    //게시글 상세조회
    @GetMapping("/api/post/{id}")
    public ResponseDto<?> getBoardById(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return boardService.getBoardByID(id, userDetails);
    }

    //게시글 수정
    @PutMapping("/api/auth/post/{id}")
    public ResponseDto<?> putBoard(@PathVariable Long id,
                                   @RequestBody BoardRequestDto requestDto,
                                   @AuthenticationPrincipal UserDetailsImpl userDetails){
        return boardService.putBoard(id, requestDto, userDetails);
    }

    //게시글 삭제
    @DeleteMapping("/api/auth/post/{id}")
    public ResponseDto<?> deleteBoard(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return boardService.deleteBoard(id, userDetails);
    }
}
