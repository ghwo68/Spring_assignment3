package com.sparta.spring04.service;

import com.sparta.spring04.dto.CommentRequestDto;
import com.sparta.spring04.dto.ResponseDto;
import com.sparta.spring04.model.Board;
import com.sparta.spring04.model.Comment;
import com.sparta.spring04.model.User;
import com.sparta.spring04.repository.BoardRepository;
import com.sparta.spring04.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

/*    //댓글 작성
    @Transactional
    public ResponseDto<?> postComment(CommentRequestDto requestDto, User user){
        Optional<Board> optionalBoard = boardRepository.findById(requestDto.getBoardId());
        if (optionalBoard.isEmpty()){
            return ResponseDto.fail("NOT_FOUND", "해당 게시글이 존재하지 않습니다.");
        }

        String author = user.getUsername();
        Comment comment = new Comment(requestDto,author);
        commentRepository.save(comment);

        Board board = optionalBoard.get();


        return ResponseDto.success(comment);
    }
 */
}
