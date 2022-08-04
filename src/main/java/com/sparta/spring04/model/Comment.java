package com.sparta.spring04.model;

import com.sparta.spring04.dto.CommentRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long boardId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;
    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    public Comment(CommentRequestDto requestDto, User user){
        this.boardId = requestDto.getBoardId();
        this.content = requestDto.getContent();
        this.user = user;
        this.author = user.getUsername();
    }

/*
    @ManyToOne
    @JoinColumn(name = "BOARD_ID", nullable = false)
    private Board board;

    public Comment(CommentRequestDto requestDto, String author){
        this.boardId = requestDto.getBoardId();
        this.content = requestDto.getContent();
        this.author = author;
    }
*/
}
