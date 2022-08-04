package com.sparta.spring04.controller;


import com.sparta.spring04.dto.ResponseDto;
import com.sparta.spring04.dto.TokenRequestDto;
import com.sparta.spring04.dto.UserSignupRequestDto;
import com.sparta.spring04.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    //회원가입 요청처리
    @PostMapping("/api/member/signup")
    public ResponseDto<?> registerUser(@RequestBody UserSignupRequestDto requestDto){
        return userService.registerUser(requestDto);
    }

    //로그인 -> 토큰발급
    @PostMapping("/api/member/login")
    public ResponseDto<?> loginUser(@RequestBody UserSignupRequestDto requestDto){
        return ResponseDto.success(userService.loginUser(requestDto));
    }

    //토큰 재발급
    @PostMapping("/api/member/reissue")
    public ResponseDto<?> reissueUser(@RequestBody TokenRequestDto requestDto){
        return ResponseDto.success(userService.reissue(requestDto));
    }
}
