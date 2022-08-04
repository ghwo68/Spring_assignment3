package com.sparta.spring04.model;

import com.sparta.spring04.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Board extends Timestamped {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
/*
    @OneToMany
    @JoinColumn(name = "BOARD_ID", nullable = true)
    private List<Comment> commentList;
*/
    public Board(BoardRequestDto requestDto, User user) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.user = user;
        this.author = user.getUsername();
    }
/*
    public Board(BoardRequestDto requestDto, String author) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.author = author;
    }
*/
    public void update(BoardRequestDto requestDto ){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}