package com.sparta.spring04.service;

import com.sparta.spring04.dto.BoardRequestDto;
import com.sparta.spring04.dto.ResponseDto;
import com.sparta.spring04.model.Board;
import com.sparta.spring04.model.User;
import com.sparta.spring04.repository.BoardRepository;
import com.sparta.spring04.repository.UserRepository;
import com.sparta.spring04.security.SecurityUtil;
import com.sparta.spring04.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    private final UserRepository userRepository;

/*
    @Transactional
    public ResponseDto<?> postBoard(BoardRequestDto requestDto, User user){
        String author = user.getUsername();
        Board board = new Board(requestDto, author);
        boardRepository.save(board);
        return ResponseDto.success(board);
    }
    @Transactional
    public ResponseDto<?> postBoard(BoardRequestDto requestDto, UserDetailsImpl userDetails){
         User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow(
                    () -> new RuntimeException("로그인 유저정보가 없습니다.")
          );
         Board board = new Board(requestDto, user);
         boardRepository.save(board);

         return ResponseDto.success(board);

*/
    //게시글 작성
    @Transactional
    public ResponseDto<?> postBoard(BoardRequestDto requestDto, UserDetailsImpl userDetails){
        User user = userRepository.findByUsername(SecurityUtil.getCurrentUserId()).orElseThrow(
                    () -> new RuntimeException("로그인 유저정보가 없습니다.")
        );
        Board board = new Board(requestDto, user);
        boardRepository.save(board);

        return ResponseDto.success(board);
    }

    //게시글 조회
    @Transactional
    public ResponseDto<?> getBoard(){

        return ResponseDto.success(boardRepository.findAllByOrderByModifiedAtDesc());
    }

    //게시글 상세조회
    @Transactional
    public ResponseDto<?> getBoardByID(Long id, UserDetailsImpl userDetails){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );

        return ResponseDto.success(board);
    }

    //게시글 수정
    @Transactional
    public ResponseDto<?> putBoard(Long id, BoardRequestDto boardRequestDto, UserDetailsImpl userDetails){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        board.update(boardRequestDto);

        return ResponseDto.success(board);
    }

    //게시글 삭제
    @Transactional
    public ResponseDto<?> deleteBoard(Long id, UserDetailsImpl userDetails){
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다")
        );
        boardRepository.delete(board);

        return ResponseDto.success(true);
    }
}
